using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class HalfMatrix
    {
        private double[][] values;
        private double minSimilarity;
        public HalfMatrix(WholeMatrix original, double minSimilarity)
        {
            this.minSimilarity = minSimilarity;
            int n = original.getN();
            values = new double[n][];
            for (int i = 0; i < n; i++)
            {
                values[i] = new double[i];
                for (int j = 0; j < i; j++)
                {
                    values[i][j] = original.getAvg(i, j);
                }
            }
        }

        public string ToString()
        {
            StringBuilder halfMatrixString = new StringBuilder();
            halfMatrixString.Append("HaflMatrix:\n");
            int i = 0;
            foreach (double[] A in values)
            {
                halfMatrixString.Append("row:" + i + "[\n");
                bool isFirst = true;
                int j = 0;
                foreach (double d in A)
                {
                    if (d > minSimilarity)
                    {
                        String val = "(" + j + ":" + String.Format("{0:0.00}", d) + ")";
                        if (!isFirst)
                        {
                            halfMatrixString.Append(",");
                        }
                        halfMatrixString.Append(val);
                        isFirst = false;
                    }
                    j++;
                }
                halfMatrixString.Append("] completed row: " + i + "\n\n");
                i++;
            }
            return halfMatrixString.ToString();
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


        public String getABC(double minEdgeWeight, Dictionary<int, int> keyConverter)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.Length; i++)
            {
                int key_i = keyConverter[i];
                for (int j = 0; j < values[i].Length; j++)
                {
                    int key_j = keyConverter[j];
                    double edgeWeight = values[i][j];

                    if (edgeWeight >= minEdgeWeight)
                    {
                        sb.Append(key_i + " " + key_j + " " + edgeWeight + "\n");
                    }
                }
                sb.Append(key_i + " " + key_i + " " + 1.0 + "\n");
            }
            return sb.ToString();
        }
    }
}
