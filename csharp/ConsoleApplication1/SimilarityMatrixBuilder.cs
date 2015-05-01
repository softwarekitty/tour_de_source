using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;
using System.IO;


namespace ConsoleApplication1
{
    public static class SimilarityMatrixBuilder
    {
        public static double initializedFlag = 0.00000987654321;
        public static double incompleteFlag = 0.00000123456789;
        public static double cancelledFlag = 0.0000050101010101;
        public static double verifiedTimeoutFlag = 0.00000701702703;
        public static double belowMinFlag = 0.00000307207107;

        public static void vasquezSays()
        {
            Console.WriteLine("let's rock");
        }


        public static void createBatchOfRows(int batchSize, string allRowsBase, string filteredCorpusPath, string rexStringsBase, double minSimilarity)
        {

            // create regexMap and keyList
            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");
            using (StreamReader r = new StreamReader(filteredCorpusPath))
            {
                string line = null;
                while ((line=r.ReadLine()) != null)
                {
                    Match lineMatch = numberFinder.Match(line);
                    if (lineMatch.Success)
                    {
                        int index = int.Parse(lineMatch.Groups[1].Value);
                        string pattern = lineMatch.Groups[2].Value;
                        regexMap.Add(index, new Regex(pattern));
                    }
                }
            }
            List<int> keyList = new List<int>(regexMap.Keys);
            keyList.Sort();

            //create some seeds so that different runs on the same data are the same
            Random gen = new Random(int.MaxValue);
            int[] differentSeeds = Enumerable.Repeat(0, keyList.Count).Select(i => gen.Next(0, int.MaxValue)).ToArray();

            //each of these will create 128 threads, so keep the paralelism down
            ParallelOptions options = new ParallelOptions();
            options.MaxDegreeOfParallelism = 4;

            //these do not have to be sequential or in order.
            int[] batchIndices = getBatchOfIndices(allRowsBase,keyList.Count, batchSize);
            Parallel.For(0, batchIndices.Length, options, i => evaluateOneRow(i, batchIndices,differentSeeds[i], rexStringsBase, regexMap, keyList, minSimilarity,allRowsBase));
        }


        static void evaluateOneRow(int batchArrayIndex, int[] batchIndices, int differentSeed, string rexStringsBase, Dictionary<int, Regex> regexMap,List<int> keyList, double minSimilarity, string rowFileBase)
        {

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            int rowIndex = batchIndices[batchArrayIndex];
            int nKeys = keyList.Count;
            double[] rowArray = new double[nKeys];
            for (int rowArrayIndex = 0; rowArrayIndex < nKeys; rowArrayIndex++)
            {
                rowArray[rowArrayIndex] = initializedFlag;
            }
            Random gen = new Random(differentSeed);

            HashSet<string> matchingStrings_outer = getRexGeneratedStrings(rowIndex,nKeys,rexStringsBase);
            double nMatchingStrings = matchingStrings_outer.Count;
            int maxErrors = (int)((1 - minSimilarity) * nMatchingStrings) + 1;

            //in order to protect against exponential worst-case regexes we chunk the row,
            //and wait in powers of two for each chunk.  It's a mess but we cannot get inside of
            //this library code: 'regex_inner.Match(matchingString)' to do propper cancelation
            int[] nTimeouts = { 0 };
            int chunkSize = 128;
            int nChunks = nKeys / chunkSize;
            int remainder = nKeys % chunkSize;
            for (int chunkIndex = 0; chunkIndex < nChunks; chunkIndex++)
            {
                int chunkStart = chunkIndex * chunkSize;
                int chunkStop = chunkStart + chunkSize;
                processChunk(rowIndex,rowArray, chunkStart, chunkStop, matchingStrings_outer, regexMap, maxErrors, keyList, nTimeouts);
            }
            if (remainder > 0)
            {
                int chunkStart = nChunks * chunkSize;
                int chunkStop = chunkStart + remainder;
                processChunk(rowIndex,rowArray, chunkStart, chunkStop, matchingStrings_outer, regexMap, maxErrors, keyList,nTimeouts);
            }
            MatrixRow mr = new MatrixRow(rowIndex,rowArray, nKeys);
            mr.writeRowToFile(rowFileBase,minSimilarity);

            stopwatch.Stop();
            TimeSpan ts = stopwatch.Elapsed;
            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}", ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("completed i: " +rowIndex + "/" + nKeys + " nTimeouts: " + nTimeouts[0] + " nMatchStrings:" + matchingStrings_outer.Count + " time taken: " + elapsedTime);
        }

        static void processChunk(int rowIndex,double[] rowArray, int chunkStart, int chunkStop, HashSet<string> matchingStrings_outer, Dictionary<int, Regex> regexMap,int maxErrors, List<int> keyList, int[] nTimeouts)
        {

            // rarely, a pathological regex can hang for a very long time.
            // but most of these finish within 120 microseconds (rate: 8300/sec)
            // usually should be able to do 128 in 16 milliseconds so start there
            int taskIndex = 0;
            Task[] tasks = new Task[chunkStop-chunkStart];
            CancellationTokenSource tokenSource = new CancellationTokenSource();
            for (int keyIndex = chunkStart; keyIndex < chunkStop; keyIndex++)
            {

                //get the regex mapped to this cell within the chunk
                int innerKey = keyList[keyIndex];
                Regex regex_inner = regexMap[innerKey];

                //wow, strange it looks like the keyIndex++
                //triggered at the end of the loop passes into the 
                //populateRowCell(...) code, so it gets the next value!
                int j_dont_increment_me = keyIndex;
                if (j_dont_increment_me >= rowArray.Length)
                {
                    Console.WriteLine();
                    throw new Exception("the j_dont_increment_me: " + j_dont_increment_me + " will be outside of the array length: " + rowArray.Length);
                }

                //create a task to populate that row cell
                //this task may hang and never die.
                tasks[taskIndex++] = Task.Factory.StartNew(() => populateRowCell(rowIndex, j_dont_increment_me, rowArray, matchingStrings_outer, regex_inner, maxErrors, tokenSource.Token));
            }
            int overheadBuffer = 3;
            int exponent = 0;
            int maxExponent = 13;
            bool chunkComplete = false;
            while (exponent < maxExponent)
            {
                // 20MS, 21MS, 23MS, 27MS, 35MS, 42MS, 83MS, 147MS, 275MS, 531MS, 1042MS, 2067MS, 4115MS
                // so if after 8428 ms, the 128 cells are not complete, set remaining cells to the flag value.
                double balloon = Math.Pow(2, exponent);
                if (Task.WaitAll(tasks, TimeSpan.FromMilliseconds(16 + balloon + overheadBuffer)))
                {
                    //all tasks in this chunk have completed, exit
                    chunkComplete = true;
                    break;
                }
                exponent++;
            }
            if (!chunkComplete)
            {
                tokenSource.Cancel();
                for (int j = chunkStart; j < chunkStop; j++)
                {
                    double currentRowValue = rowArray[j];
                    if (currentRowValue==incompleteFlag || currentRowValue==initializedFlag || currentRowValue==cancelledFlag)
                    {
                        nTimeouts[0]++;
                    }
                }
            }
        }

        static void populateRowCell(int i, int j, double[] row, HashSet<string> matchingStrings_outer, Regex regex_inner, int maxErrors,CancellationToken ct)
        {
            if (i == j)
            {
                row[j] = 1.0;
                return;
            }
            double nMatchingStrings = matchingStrings_outer.Count;
            int alsoMatchingCounter = 0;
            int errorCounter = 0;

            // for debugging - did we get this far?
            row[j] = incompleteFlag;

            foreach (string matchingString in matchingStrings_outer)
            {

                // free up resources ASAP if the task group has timed out
                if (ct.IsCancellationRequested)
                {
                    row[j] = cancelledFlag;
                    return;

                    // after a certain number of errors, it is impossible to
                    // be included anyway - give up early
                    // this may drag down some corner cases when they are
                    // averaged in the half-matrix, but will save a lot of time, 
                    // since the vast majority of these comparisons have 0 similarity
                    // anyway, maybe n^2 - n of them
                }else if(errorCounter > maxErrors){
                    break;
                }


                Match attemptMatch = regex_inner.Match(matchingString);
                if (attemptMatch.Success)
                {
                    alsoMatchingCounter++;
                }
                else
                {
                    errorCounter++;
                }
            }
            double similarity = alsoMatchingCounter / nMatchingStrings;
            row[j] = similarity;
        }

        // helpers



        private static HashSet<string> getRexGeneratedStrings(int rowIndex, int nKeys, string rexStringsBase)
        {
            string rexFilePath = Util.getRexFilePath(rexStringsBase, nKeys, rowIndex);
            HashSet<string> generatedStrings = new HashSet<string>();
            using (StreamReader r = new StreamReader(rexFilePath))
            {
                string line = null;
                while ((line = r.ReadLine()) != null)
                {
                    if (line.Length > 0)
                    {
                        generatedStrings.Add(line);
                    }
                }
            }
            return generatedStrings;
        }


        private static int[] getBatchOfIndices(string allRowsBase, int nKeys, int batchSize)
        {
            int nAdded = 0;
            List<int> indices = new List<int>();
            for (int rowIndex = 0; rowIndex < nKeys; rowIndex++)
            {
                string rowPath = Util.getRowFilePath(allRowsBase, nKeys, rowIndex);
                if (!File.Exists(rowPath))
                {
                    indices.Add(rowIndex);
                    nAdded++;
                }
                if (nAdded >= batchSize)
                {
                    return indices.ToArray();
                }
            }
            return indices.ToArray();
        }
    }
}
