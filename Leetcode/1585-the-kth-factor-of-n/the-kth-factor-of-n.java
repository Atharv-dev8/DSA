class Solution {
    public int kthFactor(int n, int k) {
        int iCount = 0;
        int iCnt = 0;
        
        for(iCount=1;iCount<=n;iCount++)
        {
            if((n%iCount) == 0)
            {
                iCnt++;
            }
            if(iCnt == k)
            {
                return iCount;
            }
        }
        return -1;
    }
}