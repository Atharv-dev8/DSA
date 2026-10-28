class Solution {
    public boolean checkPerfectNumber(int num) {
        int iCount = 0;
        int iSum   = 0;
        for(iCount=1;iCount<=num/2;iCount++)
        {
            if((num % iCount)==0)
            {
                iSum  = iSum + iCount;
            }
            
        }
        if(iSum == num)
        {
                return true;
        }
        return false;
    }
}