using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Threading.Tasks;
using System.Threading;
using System.Diagnostics;

namespace ConsoleApplication1
{
    static class TimeoutVerifier
    {
        internal static void verifyRows(string allRowsBase, int nRows, double minSimilarity, string filteredCorpusPath, int nRunnawaysWithoutStress, int batchSize, string rexStringsBase)
        {
            AppDomain domain = AppDomain.CurrentDomain;
            domain.SetData("REGEX_DEFAULT_MATCH_TIMEOUT",TimeSpan.FromSeconds(9));
            // create regexMap and keyList
            Dictionary<int, Regex> regexMap = new Dictionary<int, Regex>();
            Regex numberFinder = new Regex(@"(\d+)\t(.*)");
            using (StreamReader r = new StreamReader(filteredCorpusPath))
            {
                string line = null;
                while ((line = r.ReadLine()) != null)
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
            int[] stressCounter = {0};

            int[] indicesWithTimeouts = getBatchOfIndicesWithTimeouts(allRowsBase,nRows,batchSize);
            for (int indexKey = 0; indexKey < indicesWithTimeouts.Length; indexKey++)
            {
                if (stressCounter[0] >= nRunnawaysWithoutStress)
                {
                    break;
                }
                validateRow(indicesWithTimeouts[indexKey],nRows,keyList,regexMap,minSimilarity,allRowsBase, rexStringsBase, stressCounter);
            }
        }

        private static void validateRow(int rowIndex, int nRows, List<int> keyList, Dictionary<int, Regex> regexMap, double minSimilarity, string allRowsBase, string rexStringsBase, int[] stressCounter)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            MatrixRow mr = new MatrixRow(allRowsBase, rowIndex, nRows);
            HashSet<string> matchingStrings_outer = Util.getRexGeneratedStrings(rowIndex, nRows, rexStringsBase);
            int nMatchingStrings = matchingStrings_outer.Count;
            int maxErrors = (int)((1 - minSimilarity) * nMatchingStrings) + 1;
            double[] values = mr.getValues();
            int nTimeouts = 0;



            for (int j = 0; j < values.Length; j++)
            {
                //remember this keyList was built from the filteredCorpus,
                //with keys added in order
                int innerKey = keyList[j];
                Regex regex_inner = regexMap[innerKey];
                double similarity = values[j];

                // note that when reading the row from file, everything that
                // was not a valid similarity or below the minimum was
                // initialized to verifiedTimeout, which makes sense in an 
                // optimistic expectation that this step will be completed soon
                // after that, or has already been done.

                // so this will mean we only do a small fraction of most rows
                if (similarity == SimilarityMatrixBuilder.verifiedTimeoutFlag)
                {
                    try
                    {
                        validateCell(j, values, matchingStrings_outer, regex_inner, maxErrors);
                    }
                    catch (RegexMatchTimeoutException e)
                    {
                        nTimeouts++;
                        stressCounter[0]++;
                    }
                }
            }
            mr.writeRowToFile(allRowsBase,minSimilarity);
            stopwatch.Stop();
            TimeSpan ts = stopwatch.Elapsed;
            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}", ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("verified i: " + rowIndex + "/" + nRows + " nTimeouts: " + nTimeouts + " nMatchStrings:" + matchingStrings_outer.Count + " time taken: " + elapsedTime);
        }

        //TODO - tie this with a task that times out.
        static void validateCell(int j, double[] row, HashSet<string> matchingStrings_outer, Regex regex_inner, int maxErrors)
        {
            double nMatchingStrings = matchingStrings_outer.Count;
            int alsoMatchingCounter = 0;
            int errorCounter = 0;

            foreach (string matchingString in matchingStrings_outer)
            {

                if (errorCounter > maxErrors)
                {
                    row[j] = SimilarityMatrixBuilder.belowMinFlag;
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



        private static int[] getBatchOfIndicesWithTimeouts(string allRowsBase, int nKeys, int batchSize)
        {
            int nAdded = 0;
            List<int> indices = new List<int>();
            for (int rowIndex = 0; rowIndex < nKeys; rowIndex++)
            {
                string rowPath = Util.getRowFilePath(allRowsBase, nKeys, rowIndex);
                if (Util.hasUnverifiedTimeouts(allRowsBase,nKeys,rowIndex))
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
