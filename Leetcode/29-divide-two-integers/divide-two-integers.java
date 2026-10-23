class Solution {
    public int divide(int dividend, int divisor) {
        
        int iQuotient = 0;
        long ldividend  = dividend;
        long ldivisor = divisor;

        boolean isNegative = false;

        if (ldividend == Integer.MIN_VALUE && ldivisor == -1) 
        {
            return Integer.MAX_VALUE;
        }
        if ((ldividend < 0 && ldivisor > 0) ||
            (ldividend > 0 && ldivisor < 0)) {
            isNegative = true;
        }
        if(ldivisor<0)
        {
            ldivisor = -ldivisor;
        }
        if(ldividend<0)
        {
            ldividend = -ldividend;
        }
        while (ldividend >= ldivisor) {

        long tempDivisor = ldivisor;
        long multiple = 1;

        while (ldividend >= (tempDivisor << 1)) {
            tempDivisor <<= 1;
            multiple <<= 1;
        }

        ldividend -= tempDivisor;
        iQuotient += multiple;
         }
        if(isNegative)
        {
            iQuotient = -iQuotient;
        }
        return iQuotient;
    }
}