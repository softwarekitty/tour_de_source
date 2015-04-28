using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class WholeMatrix
    {
        private double[][] values;
        private static double weirdValue = -2.0;
        private double minSimilarity;
        public WholeMatrix(int n, double minSimilarity)
        {
            this.minSimilarity = minSimilarity;
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[n];
                for (int j = 0; j < n; j++)
                {
                    // weird value should help detect errors
                    values[i][j] = weirdValue;
                }
            }
        }

        public override string ToString()
        {
            StringBuilder wholeMatrixString = new StringBuilder();
            wholeMatrixString.Append("WholeMatrix:\n");
            int i = 0;
            foreach (double[] A in values)
            {
                wholeMatrixString.Append("row:" + i + "[\n");
                bool isFirst = true;
                int j = 0;
                foreach (double d in A)
                {
                    if (d > minSimilarity)
                    {
                        String val = "(" + j + ":" + String.Format("{0:0.00}", d) + ")";
                        if (!isFirst)
                        {
                            wholeMatrixString.Append(",");
                        }
                        wholeMatrixString.Append(val);
                        isFirst = false;
                    }
                    j++;
                }
                wholeMatrixString.Append("] completed row: " + i + "\n\n");
                i++;
            }
            return wholeMatrixString.ToString();
        }

        public double getAvg(int row, int col)
        {
            if (row == col)
            {
                return 1;
            }
            else
            {
                return (values[row][col] + values[col][row]) / 2.0;
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



        internal bool cellIsEmpty(int i, int j)
        {
            return values[i][j] == weirdValue;
        }
    }
}
