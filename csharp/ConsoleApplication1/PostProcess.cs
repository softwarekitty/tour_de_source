using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    public static class PostProcess
    {
        public static void sayBye()
        {
            Console.WriteLine("PreProcess says bye");
        }

        public static void createMatricesAndABC(string allRowsBase, int nRows, double minSimilarity, string filteredCorpusPath)
        {
            Dictionary<int, int> keyConverter = Util.getKeyConverter(getKeyList(filteredCorpusPath));
            WholeMatrix wholeMatrix = populateWholeMatrix(allRowsBase, nRows, minSimilarity);

            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\wholeMatrix.txt", wholeMatrix.ToString());
            HalfMatrix halfMatrix = new HalfMatrix(wholeMatrix, minSimilarity);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\halfMatrix.txt", halfMatrix.ToString());
            string abcContent = halfMatrix.getABC(minSimilarity, keyConverter);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\behavioralSimilarityGraph.abc", abcContent);
        }

        private static WholeMatrix populateWholeMatrix(string allRowsBase, int nRows, double minSimilarity)
        {
            WholeMatrix wholeMatrix = new WholeMatrix(nRows, minSimilarity);
            for(int rowIndex =0;rowIndex<nRows;rowIndex++){
                string rowFilePath = Util.getRowFilePath(allRowsBase, nRows, rowIndex);
                using (StreamReader r = new StreamReader(rowFilePath))
                {
                    string line = null;
                    while ((line = r.ReadLine()) != null)
                    {
                        if(line.StartsWith("similarityValues")){
                            int start = line.IndexOf("[");
                            int end = line.LastIndexOf("]");
                            string listContent = line.Substring(start+1,(end-start-1));
                            string[] similarityEntries = listContent.Split(',');
                            foreach(string entry in similarityEntries){
                                string entryContent = entry.Substring(1,entry.Length-2);
                                string[] index_value = entryContent.Split(':');
                                int colIndex = int.Parse(index_value[0]);
                                double similarityValue = double.Parse(index_value[1]);
                                wholeMatrix.set(rowIndex,colIndex,similarityValue);
                            }
                        }
                    }
                }

            }
            return wholeMatrix;
        }


        private static List<int> getKeyList(string filteredCorpusPath)
        {
            List<int> keyList = new List<int>();
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
                        keyList.Add(index);
                    }
                }
            }
            keyList.Sort();
            return keyList;
        }
    }
}
