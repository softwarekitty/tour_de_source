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
            int minStringsForViableStatistics = 1000;
            Random gen = new Random();

            string corpusFileContent = System.IO.File.ReadAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\miniCorpus.txt");

            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Dictionary<int, string> patternMap = new Dictionary<int, string>();
            string[] corpusFileLines = corpusFileContent.Split(new string[] { "\n" }, StringSplitOptions.None);
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");


            foreach (string line in corpusFileLines)
            {
                Match lineMatch = numberFinder.Match(line);
                if (lineMatch.Success)
                {
                    int index = int.Parse(lineMatch.Groups[1].Value);
                    string pattern = lineMatch.Groups[2].Value;
                    Regex regex = new Regex(pattern);
                    HashSet<string> matchingStrings = getMatchStrings(minStringsForViableStatistics,gen,pattern,regex);

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
                        Console.WriteLine("pattern failed: " + pattern);
                    }
                }
            }

            List<int> keyList = new List<int>(patternMap.Keys);
            int nKeys = keyList.Count;
            Console.WriteLine("nKeys: " + nKeys);
            Console.WriteLine("");

            // note that 65536 is 2^16, 131072 is 2^17, which is about as slow as I'd want Rex to go
            int nStringsPerPattern = 65536;
            WholeMatrix wholeMatrix = new WholeMatrix(nKeys);
            Dictionary<int, int> keyConverter = new Dictionary<int, int>();
            int i = 0;
            foreach (int outerKey in keyList)
            {
                Console.WriteLine("outerKey: "+outerKey);
                keyConverter.Add(i, outerKey);
                Regex regex_outer = regexMap[outerKey];
                string pattern_outer = patternMap[outerKey];
                HashSet<string> matchingStrings_outer = getMatchStrings(nStringsPerPattern, gen, pattern_outer, regex_outer);
                double nMatchingStrings = matchingStrings_outer.Count;
                int j = 0;
                foreach (int innerKey in keyList)
                {
                    Regex regex_inner = regexMap[innerKey];
                    int alsoMatchingCounter = 0;
                    foreach(string matchingString in matchingStrings_outer){
                        Match attemptMatch = regex_inner.Match(matchingString);
                        if (attemptMatch.Success)
                        {
                            alsoMatchingCounter++;
                        }
                    }
                    double similarity = alsoMatchingCounter/nMatchingStrings;
                    wholeMatrix.set(i,j,similarity);
                    j++;
                }
                i++;
            }
            HalfMatrix halfMatrix = new HalfMatrix(wholeMatrix);
            string abcContent = halfMatrix.getABC(0.65,keyConverter);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\behavioralSimilarityGraph.abc",abcContent);
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
            Console.WriteLine("Halfmatrix n: " + n);
            Console.WriteLine();
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
