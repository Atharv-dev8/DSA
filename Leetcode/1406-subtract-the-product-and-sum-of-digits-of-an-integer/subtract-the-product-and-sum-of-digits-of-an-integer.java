class Solution {
    public int subtractProductAndSum(int n) {
        
        int iProduct = 1;
        int iSum = 0;
        int iDigit = 0;
        int iResult = 0;

        while(n != 0)
        {
            iDigit = n % 10;
            iSum = iSum+iDigit;
            iProduct = iProduct * iDigit;
            n = n/10;
        }
        iResult = iProduct - iSum;
        return iResult;
    }
}