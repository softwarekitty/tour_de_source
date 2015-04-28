using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Diagnostics;
using System.Text;

namespace ConsoleApplication1
{
    public static class PreProcess
    {
        public static void sayHi()
        {
            Console.WriteLine("PreProcess says hi");
        }

        public static void generateFilteredCorpusAndRexFolders(string exportedCorpusPath, string filteredCorpusPath, string rexStringsBase)
        {
            //throw new NotImplementedException();
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

                string rexOutput = callRex("/r:" + tempFilePath + " /k:" + maxStrings + " /e:ASCII /s:" + gen.Next(int.MaxValue));
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
    }
}

