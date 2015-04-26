using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("begin behavioral clustering script");
            int minStringsForViableStatistics = 256;
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
                    try
                    {
                        Regex regex = new Regex(pattern);
                        int timeoutMS = 5000;
                        var task = Task.Factory.StartNew(() => getMatchStrings(minStringsForViableStatistics, gen, pattern, regex));

                        // rarely, a pathological regex can hang for a very long time.  
                        if (!task.Wait(timeoutMS)){
                            timeoutMap.Add(index, pattern);
                            Console.WriteLine("pattern timed out: " + pattern);
                            continue;
                        }
                        HashSet<string> matchingStrings = task.Result;

                        // only add regexes to the regexMap if we can generate strings from Rex that their regex will match
                        // I assume that if we can generate minStringsForViableStatistics items quickly, then we can generate nStringsPerPattern items eventually.
                        // this will exclude patterns that require exact size matches like ^abc$, or have few matching strings
                        // but how similar can these be to other patterns unless they are semantic clones?
                        if (matchingStrings.Count == minStringsForViableStatistics)
                        {
                            Console.WriteLine("pattern successful: " + pattern);
                            Console.WriteLine("");
                            regexMap.Add(index, new Regex(pattern));
                            patternMap.Add(index, pattern);
                        }
                        else
                        {
                            failureMap.Add(index, pattern);
                            Console.WriteLine("pattern failed: " + pattern);
                        }
                    }
                    catch (Exception e)
                    {
                        exceptionMap.Add(index, pattern);
                        Console.WriteLine("with pattern: " + pattern);
                        Console.WriteLine("exception: " + e.Source);
                    }
                }
            }
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\rexFailures.txt", mapToString(failureMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\exceptionFailures.txt", mapToString(exceptionMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\timeoutFailures.txt", mapToString(timeoutMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\patternMap.txt", mapToString(patternMap));


            List<int> keyList = new List<int>(patternMap.Keys);
            int nKeys = keyList.Count;
            Console.WriteLine("nKeys: " + nKeys);
            Console.WriteLine("");

            // note that 65536 is 2^16, 131072 is 2^17, which is about as slow as I'd want Rex to go
            // this was taking prohibitively long - about 8 hours to get 20 done (out of 9700)
            // int nStringsPerPattern = 65536;

            // I want to use 65536, but that could take many years.
            // I chose 380 to save time but also still wash out some error
            int nStringsPerPattern = 380;
            double minSimilarity = 0.70;

            WholeMatrix wholeMatrix = new WholeMatrix(nKeys);
            Dictionary<int, int> keyConverter = new Dictionary<int, int>();
            int[] differentSeeds = Enumerable.Repeat(0, keyList.Count).Select(i => gen.Next(0,int.MaxValue)).ToArray();
            Parallel.For(0, keyList.Count,i => evaluateOneRow(i,differentSeeds[i],keyConverter, regexMap, patternMap,nStringsPerPattern,keyList,wholeMatrix,nKeys,minSimilarity));
            HalfMatrix halfMatrix = new HalfMatrix(wholeMatrix);
            string abcContent = halfMatrix.getABC(minSimilarity,keyConverter);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\behavioralSimilarityGraph.abc",abcContent);
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
            keyConverter.Add(i, outerKey);
            Regex regex_outer = regexMap[outerKey];
            string pattern_outer = patternMap[outerKey];
            HashSet<string> matchingStrings_outer = getMatchStrings(nStringsPerPattern, gen, pattern_outer, regex_outer);
            double nMatchingStrings = matchingStrings_outer.Count;
            int maxErrors = (int)((1 - minSimilarity) * nMatchingStrings)+1;
            int errorCounter=0;
            int j = 0;
            foreach (int innerKey in keyList)
            {
                Regex regex_inner = regexMap[innerKey];
                int alsoMatchingCounter = 0;
                int timeoutCounter = 0;
                foreach (string matchingString in matchingStrings_outer)
                {
                    // rarely, a pathological regex can hang for a very long time.
                    int timeoutMS = 2000;
                    var task = Task.Factory.StartNew(() => regex_inner.Match(matchingString));  
                    if (!task.Wait(timeoutMS))
                    {
                        timeoutCounter++;
                        String pattern_inner = patternMap[innerKey];
                        Console.WriteLine("pattern timed out: " + pattern_inner);
                        continue;
                    }
                    Match attemptMatch = task.Result;
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
                double nTests = nMatchingStrings - timeoutCounter;
                // avoid dividing by 0
                if (nTests == 0)
                {
                    wholeMatrix.set(i, j, 0);
                }
                else
                {
                    wholeMatrix.set(i, j, alsoMatchingCounter / nTests);
                }
                j++;
            }
            stopwatch.Stop();
            TimeSpan ts = stopwatch.Elapsed;
            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}", ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("completed i: " + i + "/" + nKeys + " outerKey: " + outerKey + " nMatchStrings:" + matchingStrings_outer.Count + " time taken: " + elapsedTime);
                
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
        static HashSet<string> getMatchStrings(int maxStrings, Random gen, String pattern, Regex regex)
        {
            HashSet<string> matchingStrings = new HashSet<string>();

            string tempFilePath = @"C:\Users\IEUser\Desktop\temp.txt";
            System.IO.File.WriteAllText(tempFilePath, pattern);
            int maxAttempts = 9;
            int attemptCounter = 0;
            while (matchingStrings.Count < maxStrings && attemptCounter < maxAttempts)
            {

                Console.WriteLine("getMatchStrings.attemptCounter: "+attemptCounter);

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
        public WholeMatrix(int n)
        {
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[n];
                for (int j = 0; j < n; j++)
                {
                    // weird value should help detect errors
                    values[i][j] = -2.0;
                }
            }
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


    }

    class HalfMatrix
    {
        private double[][] values;
        public HalfMatrix(WholeMatrix original)
        {
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
