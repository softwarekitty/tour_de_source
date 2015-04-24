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

            string corpusFileContent = System.IO.File.ReadAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\miniCorpus.txt");

            Dictionary<int, Regex> patternMap = new Dictionary<int, Regex>();
            string[] corpusFileLines = corpusFileContent.Split(new string[] { "\n" }, StringSplitOptions.None);
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");
            string tempFilePath = @"C:\Users\IEUser\Desktop\temp.txt";
            foreach (string line in corpusFileLines)
            {
                Match lineMatch = numberFinder.Match(line);
                if (lineMatch.Success)
                {
                    int index = int.Parse(lineMatch.Groups[1].Value);
                    string pattern = lineMatch.Groups[2].Value;
                    Regex regex = new Regex(pattern);
                    patternMap.Add(index,new Regex(pattern));

                    System.IO.File.WriteAllText(tempFilePath, pattern);
                    // note that 65536 is 2^16, 131072 is 2^17, which is about as slow as I'd want Rex to go
                    string rexOutput = callRex("/r:"+tempFilePath+" /k:65536 /e:ASCII /s:23");
                    System.IO.File.WriteAllText(@"C:\Users\IEUser\Desktop\rexOutput.txt", rexOutput);
                    string[] rexOutputLines = rexOutput.Split(new string[] { "\r\n" }, StringSplitOptions.None);

                    System.IO.File.WriteAllLines(@"C:\Users\IEUser\Desktop\rexOutputSplit.txt", rexOutputLines);

                    int counter = 0;
                    foreach (string rexOutLine in rexOutputLines)
                    {
                        if (rexOutLine.Equals("")&&counter==0)
                        {
                            counter++;
                            continue;
                        }
                        Match generatedLineMatch = regex.Match(rexOutLine);
                        if (!generatedLineMatch.Success)
                        {
                            Console.WriteLine("FAILURE!! pattern: "+pattern+" failed to match: :::"+rexOutLine+":::");
                        }
                    }

                    Console.WriteLine(rexOutput.Substring(0,200));
                    Console.WriteLine("pattern successful: "+pattern);
                    Console.WriteLine("");
                }
            }

            // overwrites file
            // System.IO.File.WriteAllText(@"C:\Users\IEUser\Desktop\meoutput.txt",meoutput);
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
    }

    class WholeMatrix
    {
        private double[][] values;
        public WholeMatrix(int n)
        {
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[i];
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


        public String getABC(double minEdgeWeight)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.Length; i++)
            {
                for (int j = 0; j < values[i].Length; j++)
                {
                    double edgeWeight = values[i][j];
                    if (edgeWeight >= minEdgeWeight)
                    {
                        sb.Append(i + " " + j + " " + edgeWeight + "\n");
                    }
                }
            }
            return sb.ToString();
        }
    }
}
