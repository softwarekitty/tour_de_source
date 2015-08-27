using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;
using System.IO;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            PreProcess.sayHi();
            string output_path = @"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\csharp\";
            string filteredCorpusPath = output_path + "filteredCorpus.txt";

            string rexStringsBase = output_path + @"rexStrings\";
            Directory.CreateDirectory(rexStringsBase);

            if(!File.Exists(filteredCorpusPath)){

                //string exportedCorpusPath = @"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\analysis\analysis_output\exportedCorpusRex.txt";
                string exportedCorpusPath = @"\\vmware-host\Shared Folders\Documents\SoftwareProjects\tour_de_source\csharp\nRexStringsStudy\rexSample_2.txt";
                if (!File.Exists(exportedCorpusPath))
                {
                    Console.WriteLine("exiting because the file does not exist: " + exportedCorpusPath);
                    return;
                }
                else if (Util.countFileLines(exportedCorpusPath) < 20)
                {
                    Console.WriteLine("exiting because the file has too few lines: " + exportedCorpusPath);
                    return;
                }


                //this step ensures that all the regexes we use in the matrix cooperate with Rex
                Console.WriteLine("using exported corpus to generate filtered corpus");

                // Rex needs to generate enough strings to make the similarity scores
                // fairly meaningful but the larger the number, the longer this process takes.
                // where n is th number of regexes in the filtered corpus, the process of
                // building rows of the similarity matrix will take:
                // n^2 * nRexGeneratedStringsPerRegex * avg regex scan time (limited to 8 secs currently)
                // by inspection we do about 8300 scans per second.
                // so ignoring the killer garbage collection/runaway regexes this should take:
                // 9728*9728*384*(1/8300) = 4378247 seconds (50 days)
                // but we use 6 system threads and only actually do about 30 percent of this work,
                // which brings us down to 2.5 days of work, which is managable wrt deadlines.
                // we only have to do 30 percent because if a cell will be below minSimilarity we
                // quit early.  These values would be discared anyway, and make up the majority of values.
                int nRexGeneratedStringsPerRegex = 900;

                // note the requirement to associate lines of the filteredCorpusPath files
                // with the folders contianing rexStrings - a hazard but worth doing bc 
                // it lets us look at the exact strings used in this evaluation.
                PreProcess.generateFilteredCorpusAndRexFolders(exportedCorpusPath, filteredCorpusPath, rexStringsBase, nRexGeneratedStringsPerRegex);
                Console.WriteLine("filtered corpus and Rex folders complete");
                return;
            }
            

            string allRowsBase = output_path+@"allRows\";
            Directory.CreateDirectory(allRowsBase);
            double minSimilarity = 0.0;


            //determine nRows by inspecting the line numbers in filteredCorpus.txt
            int nRows = Util.countFileLines(filteredCorpusPath);
            int nRowsBefore = nRowsExist(allRowsBase, nRows);
            int nRexStringsToUse = 500;

            // we have to do batches bc runaway regex matchings never release memory
            int batchSize = 256;
            if (nRowsBefore==nRows)
            {
                Console.WriteLine("all row files are present! Counting unverified rows");
                int unverifiedTimeoutRows = Util.countUnverifiedRows(allRowsBase, nRows);
                if(unverifiedTimeoutRows > 0)
                 {
                    int nRunnawaysWithoutStress = 1024;
                    Console.WriteLine(unverifiedTimeoutRows+ " rows have unverified timeouts.  verifying a chunk of up to "+nRunnawaysWithoutStress+" cells with timeouts.");
                    TimeoutVerifier.verifyRows(allRowsBase,nRows,minSimilarity, filteredCorpusPath,nRunnawaysWithoutStress, batchSize, rexStringsBase, nRexStringsToUse);
                    Console.WriteLine("chunk of timeout verification complete");
                }
                else
                {
                Console.WriteLine("all cells are valid - creating matrices and abc file");
                PostProcess.createMatricesAndABC(allRowsBase, nRows, minSimilarity, filteredCorpusPath);
                Console.WriteLine("matrix and abc files are written - exiting");
                return;
                }
            }
            else
            {

                Console.WriteLine("batchSize: " + batchSize + " nRowsBefore: "+nRowsBefore+ " nRows: "+nRows);
                SimilarityMatrixBuilder.createBatchOfRows(batchSize,allRowsBase,filteredCorpusPath, rexStringsBase, minSimilarity, nRexStringsToUse);
                int nRowsAfter = nRowsExist(allRowsBase, nRows);
                Console.WriteLine("nRowsAfter: "+nRowsAfter + " diff: "+(nRowsAfter-nRowsBefore)+" batchSize:"+batchSize );
                return;
            }
        }


        private static int nRowsExist(string allRowsBase, int nRows)
        {

            // create all the bucket directories if this is the first time here
            List<string> bucketList = Util.getBucketList(nRows);
            int nBuckets = bucketList.Count;
            foreach (string bucketName in bucketList)
            {
                string rowBucketDirectory = allRowsBase + bucketName;
                Directory.CreateDirectory(rowBucketDirectory);
            }

            
            //count the times a file exists for a row in its bucket
            int numRowsExist = 0;
            for (int rowIndex = 0; rowIndex < nRows; rowIndex++)
            {

                string rowFilePath = Util.getRowFilePath(allRowsBase,nRows,rowIndex);
                if (File.Exists(rowFilePath))
                {
                    numRowsExist++;
                }
            }
            return numRowsExist;
        }
    }
}
