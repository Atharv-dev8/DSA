class Solution {
    public boolean isThree(int n) {
        int iCount = 0;
        int iCnt = 0;
        for(iCount =1;iCount<=n;iCount++)
        {
            if((n % iCount) == 0)
            {
                iCnt++;
            }
        }
        if(iCnt == 3)
        {
            return true;
        }
        return false;
    }
}