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
        public static void vasquezSays()
        {
            Console.WriteLine("let's rock");
        }


        public static int createBatchOfRows(int batchSize, string allRowsBase, string rexStringsBase, int nRows, double minSimilarity, List<int> keyList)
        {
            int nRowsCreated = 0;
            Console.WriteLine("begin creating batch of rows");

            //TODO - something like this, but a batch of files that don't exist yet in the base

            Random gen = new Random();

            //string corpusFileContent = System.IO.File.ReadAllText(analysis_output_path + "exportedCorpus.txt");

            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Dictionary<int, string> patternMap = new Dictionary<int, string>();
            Dictionary<int, string> failureMap = new Dictionary<int, string>();
            Dictionary<int, string> timeoutMap = new Dictionary<int, string>();
            Dictionary<int, string> exceptionMap = new Dictionary<int, string>();
            //string[] corpusFileLines = corpusFileContent.Split(new string[] { "\n" }, StringSplitOptions.None);
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");
            string[] corpusFileLines = { };

            foreach (string line in corpusFileLines)
            {
                Match lineMatch = numberFinder.Match(line);
                if (lineMatch.Success)
                {
                    int index = int.Parse(lineMatch.Groups[1].Value);
                    string pattern = lineMatch.Groups[2].Value;
                    regexMap.Add(index, new Regex(pattern));
                    patternMap.Add(index, pattern);
                }
            }

            //List<int> keyList = new List<int>(patternMap.Keys);
            int nKeys = keyList.Count;
            Console.WriteLine("nKeys: " + nKeys);
            Console.WriteLine("");

            // I want to use 65536, but that could take very long (20 mins per regex).
            // I chose 380 to save time but also still wash out some error
            int nStringsPerPattern = 384;
            //double minSimilarity = 0.70;

            int originalSeed = int.MaxValue;
            //Random gen = new Random(originalSeed);
            WholeMatrix wholeMatrix = new WholeMatrix(nRows, minSimilarity);
            Dictionary<int, int> keyConverter = Util.getKeyConverter(keyList);
            int[] differentSeeds = Enumerable.Repeat(0, keyList.Count).Select(i => gen.Next(0, int.MaxValue)).ToArray();
            ParallelOptions options = new ParallelOptions();
            options.MaxDegreeOfParallelism = 4;
            Parallel.For(0, keyList.Count, options, i => evaluateOneRow(i, differentSeeds[i], keyConverter, regexMap, patternMap, nStringsPerPattern, keyList, wholeMatrix, nKeys, minSimilarity));

            return nRowsCreated;
        }

        static void evaluateOneRow(int i, int differentSeed, Dictionary<int, int> keyConverter, Dictionary<int, Regex> regexMap, Dictionary<int, string> patternMap, int nStringsPerPattern, List<int> keyList, WholeMatrix wholeMatrix, int nKeys, double minSimilarity)
        {
            Random gen = new Random(differentSeed);
            int outerKey = keyList[i];
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();
            Regex regex_outer = regexMap[outerKey];
            string pattern_outer = patternMap[outerKey];
            string tempFilePath = @"C:\Users\IEUser\Desktop\tempFiles\temp" + i + ".txt";

            //fudge
            HashSet<string> matchingStrings_outer = new HashSet<string>();
                //getMatchStrings(nStringsPerPattern, gen, pattern_outer, regex_outer, tempFilePath);
            double nMatchingStrings = matchingStrings_outer.Count;
            int maxErrors = (int)((1 - minSimilarity) * nMatchingStrings) + 1;

            //in order to protect against exponential worst-case regexes we chunk the row,
            //and wait in powers of two for each chunk.  It's a mess but we cannot get inside of
            //this system code: 'regex_inner.Match(matchingString)' to do propper cancelation
            int[] nTimeouts = { 0 };
            int chunkSize = 128;
            int nChunks = nKeys / chunkSize;
            int remainder = nKeys % chunkSize;
            for (int chunkIndex = 0; chunkIndex < nChunks; chunkIndex++)
            {
                int chunkStart = chunkIndex * chunkSize;
                int chunkStop = chunkStart + chunkSize;
                processChunk(i, chunkSize, chunkStart, chunkStop, matchingStrings_outer, regexMap, maxErrors, keyList, wholeMatrix, nTimeouts);
            }
            if (remainder > 0)
            {
                int chunkStart = nChunks * chunkSize;
                int chunkStop = chunkStart + remainder;
                processChunk(i, remainder, chunkStart, chunkStop, matchingStrings_outer, regexMap, maxErrors, keyList, wholeMatrix, nTimeouts);
            }
            stopwatch.Stop();
            TimeSpan ts = stopwatch.Elapsed;
            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}", ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("completed i: " + i + "/" + nKeys + " nTimeouts: " + nTimeouts[0] + " nMatchStrings:" + matchingStrings_outer.Count + " time taken: " + elapsedTime);

        }

        static void processChunk(int i, int chunkSize, int chunkStart, int chunkStop, HashSet<string> matchingStrings_outer, Dictionary<int, Regex> regexMap, int maxErrors, List<int> keyList, WholeMatrix wholeMatrix, int[] nTimeouts)
        {
            // rarely, a pathological regex can hang for a very long time.
            // but most of these finish within 120 microseconds (rate: 8300/sec)
            // usually should be able to do 128 in 16 milliseconds so start there
            int taskIndex = 0;
            Task[] tasks = new Task[chunkSize];
            for (int keyIndex = chunkStart; keyIndex < chunkStop; keyIndex++)
            {
                int innerKey = keyList[keyIndex];
                Regex regex_inner = regexMap[innerKey];
                tasks[taskIndex] = Task.Factory.StartNew(() => populateMatrixCell(i, keyIndex, wholeMatrix, matchingStrings_outer, regex_inner, maxErrors));
                taskIndex++;
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
                double incompleteFlag = 0.0000012345;
                for (int j = chunkStart; j < chunkStop; j++)
                {
                    if (wholeMatrix.cellIsEmpty(i, j))
                    {
                        wholeMatrix.set(i, j, incompleteFlag);
                        nTimeouts[0]++;
                    }
                }

            }

        }

        static void populateMatrixCell(int i, int j, WholeMatrix wholeMatrix, HashSet<string> matchingStrings_outer, Regex regex_inner, int maxErrors)
        {
            if (j >= wholeMatrix.getN() || i >= wholeMatrix.getN())
            {
                //Console.WriteLine("j: " + j);
                //Console.WriteLine();

                //tired of tracing this.  Not sure how j is getting one too large, but I will just skip it here.
                return;
            }
            double nMatchingStrings = matchingStrings_outer.Count;
            int alsoMatchingCounter = 0;
            int errorCounter = 0;
            foreach (string matchingString in matchingStrings_outer)
            {
                Match attemptMatch = regex_inner.Match(matchingString);
                if (attemptMatch.Success)
                {
                    alsoMatchingCounter++;
                }
                else
                {
                    errorCounter++;
                }

                // after a certain number of errors, it is impossible to
                // be included anyway - give up early
                // this may drag down some corner cases when they are
                // averaged in the half-matrix, but will save a lot of time, 
                // since the vast majority of these comparisons have 0 similarity
                // anyway, maybe n^2 - n of them
                if (errorCounter > maxErrors)
                {
                    break;
                }
            }
            double similarity = alsoMatchingCounter / nMatchingStrings;
            wholeMatrix.set(i, j, similarity);
        }
    }
}
