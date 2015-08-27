using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Diagnostics;
using System.Text;
using System.IO;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public static class PreProcess
    {
        public static void sayHi()
        {
            Console.WriteLine("PreProcess says hi");
        }

        public static void generateFilteredCorpusAndRexFolders(string exportedCorpusPath, string filteredCorpusPath, string rexStringsBase, int nRexGeneratedStringsPerRegex)
        {
            Regex numberFinder = new Regex(@"(\d+)\t(\d)\t(.*)\t(.*)");
            Random gen = new Random(int.MaxValue);
            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Dictionary<int, string> patternMap = new Dictionary<int, string>();
            Dictionary<int, string> failureMap = new Dictionary<int, string>();
            Dictionary<int, string> timeoutMap = new Dictionary<int, string>();
            Dictionary<int, string> exceptionMap = new Dictionary<int, string>();

            using (StreamReader r = new StreamReader(exportedCorpusPath))
            {
                string line = null;
                while ((line = r.ReadLine()) != null)
                {
                    Match lineMatch = numberFinder.Match(line);
                    if (lineMatch.Success)
                    {
                        int index = int.Parse(lineMatch.Groups[1].Value);
                        string pattern = lineMatch.Groups[4].Value;
                        Console.WriteLine("i: "+index+" pattern: "+pattern);

                        string tempFilePath = Util.getTempFilePath(index);
                        try
                        {
                            Regex regex = new Regex(pattern);
                            int timeoutMS = 8000;
                            var task = Task.Factory.StartNew(() => getMatchStrings(nRexGeneratedStringsPerRegex, gen, pattern, regex,tempFilePath));

                            // rarely, a pathological regex can hang for a very long time.  
                            if (!task.Wait(timeoutMS))
                            {
                                timeoutMap.Add(index, pattern);
                                Console.WriteLine("pattern timed out: " + pattern);
                                continue;
                            }
                            HashSet<string> matchingStrings = task.Result;

                            // only add regexes to the regexMap if we can generate strings from Rex that their regex will match
                            // I assume that if we can generate minStringsForViableStatistics items quickly, then we can generate nStringsPerPattern items eventually.
                            // this will exclude patterns that require exact size matches like ^abc$, or have few matching strings
                            // but how similar can these be to other patterns unless they are semantic clones?
                            if (matchingStrings.Count == nRexGeneratedStringsPerRegex)
                            {
                                patternMap.Add(index, pattern);
                                regexMap.Add(index,regex);
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
            }
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\failureMap.txt", Util.mapToString(failureMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\exceptionMap.txt", Util.mapToString(exceptionMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\timeoutMap.txt", Util.mapToString(timeoutMap));
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\filteredCorpus.txt", Util.mapToString(patternMap));


            // now we have the keys of the filtered regexes
            List<int> keyList = new List<int>(patternMap.Keys);
            keyList.Sort();
            int nKeys = keyList.Count;

            // create all the bucket directories if this is the first time here
            List<string> bucketList = Util.getBucketList(nKeys);
            int nBuckets = bucketList.Count;
            foreach (string bucketName in bucketList)
            {
                string rowBucketDirectory = rexStringsBase + bucketName;
                Directory.CreateDirectory(rowBucketDirectory);
            }

            //populate the rex path files with strings chosen by Rex
            //this could be remembered or done earlier, but this won't take that long
            for (int i = 0; i < nKeys; i++)
            {
                int actualIndex = keyList[i];
                string rexPath = Util.getRexFilePath(rexStringsBase,nKeys,i);
                HashSet<string> matchingStrings = getMatchStrings(nRexGeneratedStringsPerRegex, gen, patternMap[actualIndex], regexMap[actualIndex], Util.getTempFilePath(i));
                System.IO.File.WriteAllText(rexPath, getDelimitedRexFileContent(matchingStrings));
                HashSet<string> reconstitutedMatchingStrings = Util.getRexGeneratedStrings(i, nKeys, rexStringsBase, nRexGeneratedStringsPerRegex);
                if (!matchingStrings.SetEquals(reconstitutedMatchingStrings))
                {
                    throw new Exception("must be able to get original Rex strings back from rex strings file");
                }
            }
        }

        static String getDelimitedRexFileContent(HashSet<String> matchingStrings)
        {
            StringBuilder sb = new StringBuilder();
            foreach (string ms in matchingStrings)
            {
                sb.Append(ms + Util.getRexDelimiter());
            }
            string rexFileContent = sb.ToString();
            return sb.ToString();
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

                    //this says to skip over a first blank line
                    if (rexOutLine.Equals("") && counter == 0)
                    {
                        counter++;
                        continue;
                    }
                    //Console.WriteLine("rexOutLine: "+rexOutLine);
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
            //Console.WriteLine("original:::" + rexLine + "::: noQuotes:::" + unescaped + ":::");
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

