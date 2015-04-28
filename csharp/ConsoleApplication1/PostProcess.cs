using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public static class PostProcess
    {
        public static void sayBye()
        {
            Console.WriteLine("PreProcess says bye");
        }

        public static void createMatricesAndABC(string allRowsBase, int nRows, double minSimilarity, List<int> keyList)
        {
            Dictionary<int, int> keyConverter = Util.getKeyConverter(keyList);
            WholeMatrix wholeMatrix = populateWholeMatrix(allRowsBase,nRows, minSimilarity);

            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\wholeMatrix.txt", wholeMatrix.ToString());
            HalfMatrix halfMatrix = new HalfMatrix(wholeMatrix, minSimilarity);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\halfMatrix.txt", halfMatrix.ToString());
            string abcContent = halfMatrix.getABC(minSimilarity, keyConverter);
            System.IO.File.WriteAllText(@"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\behavioralSimilarityGraph.abc", abcContent);
        }

        private static WholeMatrix populateWholeMatrix(string allRowsBase, int nRows, double minSimilarity)
        {
            WholeMatrix wholeMatrix = new WholeMatrix(nRows, minSimilarity);
            //...todo read files and put the numbers into the wholeMatrix
            return wholeMatrix;
        }
    }
}
