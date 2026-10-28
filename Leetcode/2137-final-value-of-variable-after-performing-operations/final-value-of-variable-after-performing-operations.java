class Solution {
    public int finalValueAfterOperations(String[] operations) {
       int iCount = 0;
        for(int i = 0;i<operations.length;i++)
        {
            char ch = operations[i].charAt(1);
            {
                if(ch=='+') 
                {
                    iCount++;
                }
                else if(ch == '-')
                {
                    iCount--;
                }
            }
        }
        return iCount;
    }
}