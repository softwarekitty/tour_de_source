using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("begin behavioral clustering script");
            Random gen = new Random();

            string corpusFileContent = System.IO.File.ReadAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\exportedCorpus.txt");

            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Dictionary<int, string> patternMap = new Dictionary<int, string>();
            Dictionary<int, string> failureMap = new Dictionary<int, string>();
            Dictionary<int, string> timeoutMap = new Dictionary<int, string>();
            Dictionary<int, string> exceptionMap = new Dictionary<int, string>();
            string[] corpusFileLines = corpusFileContent.Split(new string[] { "\n" }, StringSplitOptions.None);
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");


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

            List<int> keyList = new List<int>(patternMap.Keys);
            int nKeys = keyList.Count;
            Console.WriteLine("nKeys: " + nKeys);
            Console.WriteLine("");

            // I want to use 65536, but that could take very long (20 mins per regex).
            // I chose 380 to save time but also still wash out some error
            int nStringsPerPattern = 384;
            double minSimilarity = 0.70;

            WholeMatrix wholeMatrix = new WholeMatrix(nKeys, minSimilarity);
            Dictionary<int, int> keyConverter = initializeKeyConverter(keyList);
            int[] differentSeeds = Enumerable.Repeat(0, keyList.Count).Select(i => gen.Next(0,int.MaxValue)).ToArray();
            ParallelOptions options = new ParallelOptions();
            options.MaxDegreeOfParallelism = 4;
            Parallel.For(0, keyList.Count,options,i => evaluateOneRow(i,differentSeeds[i],keyConverter, regexMap, patternMap,nStringsPerPattern,keyList,wholeMatrix,nKeys,minSimilarity));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\wholeMatrix.txt", wholeMatrix.ToString());
            HalfMatrix halfMatrix = new HalfMatrix(wholeMatrix, minSimilarity);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\halfMatrix.txt", halfMatrix.ToString());
            string abcContent = halfMatrix.getABC(minSimilarity,keyConverter);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\behavioralSimilarityGraph.abc",abcContent);
        }

        private static Dictionary<int, int> initializeKeyConverter(List<int> keyList)
        {
            Dictionary<int, int> keyConverter = new Dictionary<int, int>();
            for (int i = 0; i < keyList.Count; i++)
            {
                keyConverter.Add(i, keyList[i]);
            }
            return keyConverter;
        }

        static string mapToString(Dictionary<int, string> failureMap)
        {
            StringBuilder sb = new StringBuilder();
            List<int> keyList = new List<int>(failureMap.Keys);
            foreach (int key in keyList)
            {
                sb.Append(key + "\t"+ failureMap[key]+"\n");
            }
            return sb.ToString();
        }

        static void evaluateOneRow(int i, int differentSeed, Dictionary<int, int> keyConverter, Dictionary<int, Regex> regexMap, Dictionary<int, string> patternMap, int nStringsPerPattern, List<int> keyList, WholeMatrix wholeMatrix, int nKeys, double minSimilarity)
        {
            Random gen = new Random(differentSeed);
            int outerKey = keyList[i];
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();
            Regex regex_outer = regexMap[outerKey];
            string pattern_outer = patternMap[outerKey];
            string tempFilePath = @"C:\Users\IEUser\Desktop\tempFiles\temp"+i+".txt";
            HashSet<string> matchingStrings_outer = getMatchStrings(nStringsPerPattern, gen, pattern_outer, regex_outer, tempFilePath);
            double nMatchingStrings = matchingStrings_outer.Count;
            int maxErrors = (int)((1 - minSimilarity) * nMatchingStrings)+1;

            //in order to protect against exponential worst-case regexes we chunk the row,
            //and wait in powers of two for each chunk.  It's a mess but we cannot get inside of
            //this system code: 'regex_inner.Match(matchingString)' to do propper cancelation
            int[] nTimeouts = {0};
            int chunkSize = 128;
            int nChunks = nKeys / chunkSize;
            int remainder = nKeys % chunkSize;
            for (int chunkIndex = 0; chunkIndex < nChunks; chunkIndex++)
            {
                int chunkStart = chunkIndex * chunkSize;
                int chunkStop = chunkStart + chunkSize;
                processChunk(i,chunkSize, chunkStart, chunkStop, matchingStrings_outer, regexMap, maxErrors,keyList,  wholeMatrix, nTimeouts);
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

        static void processChunk(int i,int chunkSize, int chunkStart, int chunkStop, HashSet<string> matchingStrings_outer, Dictionary<int, Regex> regexMap, int maxErrors,List<int> keyList, WholeMatrix wholeMatrix, int[] nTimeouts)
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
                tasks[taskIndex] = Task.Factory.StartNew(() => populateMatrixCell(i,keyIndex,wholeMatrix,matchingStrings_outer, regex_inner, maxErrors));
                taskIndex++;
            }
            int overheadBuffer = 3;
            int exponent = 0;
            int maxExponent = 13;
            bool chunkComplete=false;
            while (exponent < maxExponent)
            {
                // 20MS, 21MS, 23MS, 27MS, 35MS, 42MS, 83MS, 147MS, 275MS, 531MS, 1042MS, 2067MS, 4115MS
                // so if after 8428 ms, the 128 cells are not complete, set remaining cells to the flag value.
                double balloon = Math.Pow(2,exponent);
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
            if (j >= wholeMatrix.getN()|| i >=wholeMatrix.getN())
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

        static string callRex(string rexArgs)
        {
            Process p = new Process();
            p.StartInfo.FileName = @"C:\Users\IEUser\Desktop\Rex.exe";
            p.StartInfo.Arguments = rexArgs;
            p.StartInfo.UseShellExecute = false;
            p.StartInfo.RedirectStandardOutput = true;
            p.Start();

            string output = p.StandardOutput.ReadToEnd();
            p.WaitForExit();
            return output;
        }


        static string unescapeRexLine(string rexLine)
        {
            int lineLength = rexLine.Length;
            StringBuilder unescaped = new StringBuilder().Append(rexLine.Substring(1, lineLength - 2));
            //Console.WriteLine("original:::"+rexLine+"::: noQuotes:::"+unescaped.ToString()+":::");

            unescaped.Replace(@"\\", @"\");
            unescaped.Replace(@"\n", "\n");
            unescaped.Replace(@"\t", "\t");
            unescaped.Replace(@"\f", "\f");
            unescaped.Replace(@"\r", "\r");
            unescaped.Replace(@"\b", "\b");
            unescaped.Replace(@"\v", "\v");

            return unescaped.ToString();
        }


        // two things can happen: get maxStrings matchingStrings, or get fewer after trying maxAttempts times
        static HashSet<string> getMatchStrings(int maxStrings, Random gen, String pattern, Regex regex, string tempFilePath)
        {
            HashSet<string> matchingStrings = new HashSet<string>();

            System.IO.File.WriteAllText(tempFilePath, pattern);
            int maxAttempts = 9;
            int attemptCounter = 0;
            while (matchingStrings.Count < maxStrings && attemptCounter < maxAttempts)
            {

                //Console.WriteLine("getMatchStrings.attemptCounter: "+attemptCounter);

                string rexOutput = callRex("/r:" + tempFilePath + " /k:"+maxStrings+" /e:ASCII /s:" + gen.Next(int.MaxValue));
                string[] rexOutputLines = rexOutput.Split(new string[] { "\r\n" }, StringSplitOptions.None);

                // for debugging
                //System.IO.File.WriteAllText(@"C:\Users\IEUser\Desktop\rexOutput.txt", rexOutput);
                //System.IO.File.WriteAllLines(@"C:\Users\IEUser\Desktop\rexOutputSplit.txt", rexOutputLines);

                int counter = 0;
                foreach (string rexOutLine in rexOutputLines)
                {
                    if (matchingStrings.Count == maxStrings)
                    {
                        break;
                    }
                    if (rexOutLine.Equals("") && counter == 0)
                    {
                        counter++;
                        continue;
                    }
                    string unescapedGeneratedLine = unescapeRexLine(rexOutLine);
                    Match generatedLineMatch = regex.Match(unescapedGeneratedLine);
                    if (generatedLineMatch.Success)
                    {
                        matchingStrings.Add(unescapedGeneratedLine);
                    }
                }

                //stop trying after a while
                attemptCounter++;
            }

            return matchingStrings;
        }
    }

    class WholeMatrix
    {
        private double[][] values;
        private static double weirdValue = -2.0;
        private double minSimilarity;
        public WholeMatrix(int n, double minSimilarity)
        {
            this.minSimilarity = minSimilarity;
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[n];
                for (int j = 0; j < n; j++)
                {
                    // weird value should help detect errors
                    values[i][j] = weirdValue;
                }
            }
        }

        public override string ToString()
        {
            StringBuilder wholeMatrixString = new StringBuilder();
            wholeMatrixString.Append("WholeMatrix:\n");
            int i = 0;
            foreach (double[] A in values){
                wholeMatrixString.Append("row:"+i+"[\n");
                bool isFirst = true;
                int j=0;
                foreach(double d in A){
                    if (d > minSimilarity)
                    {
                        String val = "("+j+":"+String.Format("{0:0.00}", d)+")";
                        if(!isFirst){
                            wholeMatrixString.Append(",");
                        }
                        wholeMatrixString.Append(val);
                        isFirst = false;
                    }
                    j++;
                }
                wholeMatrixString.Append("] completed row: "+i+"\n\n");
                i++;
            }
            return wholeMatrixString.ToString();
        }

        public double getAvg(int row, int col)
        {
            if (row == col)
            {
                return 1;
            }
            else
            {
                return (values[row][col]+values[col][row])/2.0;
            }
        }

        public void set(int row, int col, double d)
        {
            if (row == col)
            {
                return;
            }
            else
            {
                values[row][col] = d;
            }
        }

        public int getN()
        {
            return values.Length;
        }



        internal bool cellIsEmpty(int i, int j)
        {
            return values[i][j] == weirdValue;
        }
    }

    class HalfMatrix
    {
        private double[][] values;
        private double minSimilarity;
        public HalfMatrix(WholeMatrix original, double minSimilarity)
        {
            this.minSimilarity = minSimilarity;
            int n = original.getN();
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[i];
                for (int j = 0; j < i; j++)
                {
                    values[i][j] = original.getAvg(i,j);
                }
            }
        }

        public string ToString()
        {
            StringBuilder halfMatrixString = new StringBuilder();
            halfMatrixString.Append("HaflMatrix:\n");
            int i = 0;
            foreach (double[] A in values)
            {
                halfMatrixString.Append("row:" + i + "[\n");
                bool isFirst = true;
                int j = 0;
                foreach (double d in A)
                {
                    if (d > minSimilarity)
                    {
                        String val = "(" + j + ":" + String.Format("{0:0.00}", d) + ")";
                        if (!isFirst)
                        {
                            halfMatrixString.Append(",");
                        }
                        halfMatrixString.Append(val);
                        isFirst = false;
                    }
                    j++;
                }
                halfMatrixString.Append("] completed row: " + i + "\n\n");
                i++;
            }
            return halfMatrixString.ToString();
        }

        //row is i, col is j
        //so triangle is in lower left
        public double get(int row, int col)
        {
            if (row == col)
            {
                return 1;
            }
            else if (row < col)
            {
                return values[col][row];
            }
            else
            {
                return values[row][col];
            }
        }


        //row is i, col is j
        //so triangle is in lower left
        public void set(int row, int col, double d)
        {
            if (row == col)
            {
                return;
            }
            if (row < col)
            {
                values[col][row] = d;
            }
            else
            {
                values[row][col] = d;
            }
        }


        public String getABC(double minEdgeWeight, Dictionary<int,int> keyConverter)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.Length; i++)
            {
                int key_i = keyConverter[i];
                for (int j = 0; j < values[i].Length; j++)
                {
                    int key_j = keyConverter[j];
                    double edgeWeight = values[i][j];
                    if (edgeWeight >= minEdgeWeight)
                    {
                        sb.Append(key_i + " " + key_j + " " + edgeWeight + "\n");
                    }
                }
            }
            return sb.ToString();
        }
    }
}
