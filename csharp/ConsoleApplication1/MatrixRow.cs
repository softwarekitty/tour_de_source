using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Text.RegularExpressions;

namespace ConsoleApplication1
{

    class MatrixRow
    {

        private int rowIndex;
        private double[] values;
        private int nCols;

        public MatrixRow(int rowIndex,double[] values, int nCols)
        {
            this.rowIndex = rowIndex;
            this.values = values;
            this.nCols = nCols;
        }

        public MatrixRow(string rowFileBase, int rowIndex, int nCols)
        {
            this.nCols = nCols;
            this.rowIndex = rowIndex;
            this.values = computeValuesFromFileContents(rowFileBase);
        }

        public double[] getValues()
        {
            return values;
        }

        public void setValues(double[] vals)
        {
            this.values = vals;
        }

        private double[] computeValuesFromFileContents(string rowFileBase)
        {
            double[] valuesFromFile = new double[nCols];
            for (int i = 0; i < nCols; i++)
            {
                valuesFromFile[i] = SimilarityMatrixBuilder.verifiedTimeoutFlag;
            }
            string rowFilePath = Util.getRowFilePath(rowFileBase, nCols, rowIndex);
            List<string> timedOutColIndices = new List<string>();

            using (StreamReader r = new StreamReader(rowFilePath))
            {
                string line = null;
                while ((line = r.ReadLine()) != null)
                {
                    if (line.StartsWith("belowMinimumList"))
                    {
                        setBelowMinValues(line,valuesFromFile);
                    }
                    else if (line.StartsWith("similarityValues:"))
                    {
                        setSimilarityValues(line,valuesFromFile);
                    }
                    //do nothing for other rows - these cols can use the verifiedTimeoutFlag they already have
                    //we will set these to belowMinimum if they exceed nErrors
                }
            }

            return valuesFromFile;
        }

        private void setSimilarityValues(string line, double[] vals)
        {
            string similarityValueList = removeBrackets(line);
            MatchCollection matches = Regex.Matches(similarityValueList, @"(\((.*?)\))");
            foreach (Match match in matches)
            {
                string pair = match.Groups[2].Value;
                string[] splitPair = pair.Split(':');
                int colIndex = Convert.ToInt32(splitPair[0]);
                double colValue = Convert.ToDouble(splitPair[1]);
                vals[colIndex] = colValue;
            }

        }

        private void setBelowMinValues(string line, double[] vals)
        {
            string[] indices = removeBrackets(line).Split(',');

            //some of these are empty
            foreach (string indexString in indices)
            {
                if (indexString.Length > 0)
                {
                    int colIndex = Convert.ToInt32(indexString);
                    vals[colIndex] = SimilarityMatrixBuilder.belowMinFlag;
                }
            }
        }

        private string removeBrackets(string line)
        {
            int startIndex = line.IndexOf("[");
            int endIndex = line.IndexOf("]");
            return line.Substring(startIndex + 1, (endIndex-startIndex-1));
        }

        public void writeRowToFile(string rowFileBase, double minSimilarity)
        {
            bool[] notFirstFlags = new bool[5];

            StringBuilder initializedList = new StringBuilder();
            StringBuilder incompleteList = new StringBuilder();
            StringBuilder cancelledList = new StringBuilder();
            StringBuilder belowMinimumList = new StringBuilder();
            StringBuilder similarityValues = new StringBuilder();

            initializedList.Append("initializedList: [");
            incompleteList.Append("incompleteList: [");
            cancelledList.Append("cancelledList: [");
            belowMinimumList.Append("belowMinimumList: [");
            similarityValues.Append("similarityValues: [");


            for (int j = 0; j < values.Length; j++)
            {
                double value_j = values[j];
                if (value_j == SimilarityMatrixBuilder.initializedFlag)
                {
                    if (notFirstFlags[0])
                    {
                        initializedList.Append(",");
                    }
                    initializedList.Append(j);
                }
                else if (value_j == SimilarityMatrixBuilder.incompleteFlag)
                {
                    if (notFirstFlags[1])
                    {
                        incompleteList.Append(",");
                    }
                    incompleteList.Append(j);
                }
                else if (value_j == SimilarityMatrixBuilder.cancelledFlag)
                {
                    if (notFirstFlags[2])
                    {
                        cancelledList.Append(",");
                    }
                    cancelledList.Append(j);
                }
                else if (value_j < minSimilarity)
                {
                    if (notFirstFlags[3])
                    {
                        belowMinimumList.Append(",");
                    }
                    belowMinimumList.Append(j);
                }
                else
                {
                    if (notFirstFlags[4])
                    {
                        //oops I'd like to correct this to similarityValues.Append(",");
                        //but so many already look like this, perhaps best just leave it 
                        //until it becomes important
                        belowMinimumList.Append(",");
                    }
                    similarityValues.Append("(");
                    similarityValues.Append(j);
                    similarityValues.Append(":");
                    similarityValues.Append(String.Format("{0:0.0000}", value_j));
                    similarityValues.Append(")");
                }

                //set not first to true - this is for comma neatness
                if (!notFirstFlags[0])
                {
                    for (int x = 0; x < notFirstFlags.Length; x++)
                    {
                        notFirstFlags[x] = true;
                    }
                }
            }
            initializedList.Append("]\n");
            incompleteList.Append("]\n");
            cancelledList.Append("]\n");
            belowMinimumList.Append("]\n");
            similarityValues.Append("]\n");

            StringBuilder rowFileContent = new StringBuilder();
            rowFileContent.Append(initializedList.ToString());
            rowFileContent.Append(incompleteList.ToString());
            rowFileContent.Append(cancelledList.ToString());
            rowFileContent.Append(belowMinimumList.ToString());
            rowFileContent.Append(similarityValues.ToString());

            string rowFilePath = Util.getRowFilePath(rowFileBase, nCols, rowIndex);
            System.IO.File.WriteAllText(rowFilePath, rowFileContent.ToString());
        }

    }
}
