for i in range(0,100):
    i_str = str(i)
    if len(i_str)==1:
        i_str = "0"+i_str
    print i_str
    
    
        private void setSimilarityValues(string line)
        {
            string similarityValueList = removeBrackets(line);
            MatchCollection matches = Regex.Matches(similarityValueList, @"(\((.*?)\))");
            foreach (Match match in matches)
            {
                string pair = match.Groups[2].Value;
                string[] splitPair = pair.split(":");
                int colIndex = Convert.ToInt32(splitPair[0]);
                double colValue = Convert.ToDouble(splitPair[1]);
                values[colIndex] = colValue;
            }
            
        }

        private void setBelowMinValues(string line)
        {
            string[] indices = removeBrackets(line).split(",");
            
            //some of these are empty
            foreach (string indexString in indices)
            {
                if (indexString.Length() > 0)
                {
                    int colIndex = Convet.ToInt32(indexString);
                    values[colIndex] = SimilarityMatrixBuilder.belowMinFlag;
                }
            }
        }
        
        private string removeBrackets(string line)
        {
            int startIndex = line.IndexOf("[");
            int endIndex = line.IndexOf("]");
            return line.Substring(startIndex+1,endIndex);
        }