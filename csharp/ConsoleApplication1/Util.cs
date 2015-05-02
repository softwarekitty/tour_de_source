using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    public static class Util
    {
        public static List<string> getBucketList(int nKeys)
        {
            List<string> bucketNames = new List<string>();

            //number of buckets is close to number of files in buckets
            //this is just for ease of use when file exploring
            int nBuckets = (int)Math.Sqrt(nKeys) + 1;
            int nChars = nBuckets.ToString().Length;
            for (int i = 0; i <= nBuckets; i++)
            {
                StringBuilder bucketString = new StringBuilder();
                string intString = i.ToString();
                bucketString.Append(intString);
                int nZeroPads = nChars - intString.Length;
                for (int padIndex = 0; padIndex < nZeroPads; padIndex++)
                {
                    bucketString.Insert(0, "0");
                }
                bucketNames.Add(bucketString.ToString());
            }
            return bucketNames;
        }

        public static string decideBucket(int rowNumber, int nBuckets)
        {
            int bucketID = rowNumber / nBuckets;
            int nChars = nBuckets.ToString().Length;
            StringBuilder bucketString = new StringBuilder();
            bucketString.Append(bucketID.ToString());
            int nZeroPads = nChars - bucketString.Length;
            for (int padIndex = 0; padIndex < nZeroPads; padIndex++)
            {
                bucketString.Insert(0,"0");
            }
            return bucketString.ToString();
        }

        public static string mapToString(Dictionary<int, string> sourceMap)
        {
            StringBuilder sb = new StringBuilder();
            List<int> keyList = new List<int>(sourceMap.Keys);
            foreach (int key in keyList)
            {
                sb.Append(key + "\t" + sourceMap[key] + "\n");
            }
            return sb.ToString();
        }

        public static string getTempFilePath(int i)
        {
            string tempFileFolder = @"C:\Users\IEUser\Desktop\tempFiles\";
            return tempFileFolder + "temp_" + i + ".txt";
        }

        //credit Juliet: SO#496663
        public static int countFileLines(string path)
        {
            using (StreamReader r = new StreamReader(path))
            {
                int nLines = 0;
                while (r.ReadLine() != null)
                {
                    nLines++;
                }
                return nLines;
            }
        }

        //in Util so that we get the same name when calling from different places
        public static string getRowFilePath(string allRowsBase, int nKeys, int rowIndex)
        {
            int nBuckets = (int)Math.Sqrt(nKeys) + 1;
            string bucketName = Util.decideBucket(rowIndex, nBuckets);
            string rowFilePath = allRowsBase + bucketName + @"\row_" + rowIndex.ToString() + ".txt";
            return rowFilePath;
        }


        public static Dictionary<int, int> getKeyConverter(List<int> keyList)
        {
            Dictionary<int, int> keyConverter = new Dictionary<int, int>();
            for (int i = 0; i < keyList.Count; i++)
            {
                keyConverter.Add(i, keyList[i]);
            }
            return keyConverter;
        }

        public static string getRexFilePath(string rexStringsBase, int nKeys, int rowIndex)
        {
            int nBuckets = (int)Math.Sqrt(nKeys) + 1;
            string bucketName = Util.decideBucket(rowIndex, nBuckets);
            string rowFilePath = rexStringsBase + bucketName + @"\rex_" + rowIndex.ToString() + ".txt";
            return rowFilePath;
        }

        public static string setToString(HashSet<string> matchingStrings)
        {
            StringBuilder sb = new StringBuilder();
            foreach (string ms in matchingStrings)
            {
                sb.Append(ms + "\n");
            }
            return sb.ToString();
        }

        public static int countUnverifiedRows(string allRowsBase, int nRows)
        {
            int nUnverifiedRows = 0;
            for(int rowIndex=0;rowIndex<nRows;rowIndex++)
            {
                if (hasUnverifiedTimeouts(allRowsBase,nRows,rowIndex))
                {
                    nUnverifiedRows++;
                }
            }
            return nUnverifiedRows;
        }

        public static bool hasUnverifiedTimeouts(string allRowsBase, int nRows, int rowIndex)
        {
            string rowFilePath = Util.getRowFilePath(allRowsBase, nRows, rowIndex);
            using (StreamReader r = new StreamReader(rowFilePath))
            {
                string line1 = r.ReadLine();
                string line2 = r.ReadLine();
                string line3 = r.ReadLine();
                if (!(line1.Equals("initializedList: []") && line2.Equals("incompleteList: []") && line3.Equals("cancelledList: []")))
                {
                    return true;
                }
            }
            return false;
        }


        public static HashSet<string> getRexGeneratedStrings(int rowIndex, int nKeys, string rexStringsBase)
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

        public static bool waitForTasks(Task[] tasks)
        {
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
            return chunkComplete;
        }
    }
}
