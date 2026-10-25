class Solution {
    public int countDigits(int num) {
        int iCount = 0;
        int iDigit = 0;
        int Orgnum = num;
        
        while(num != 0)
        {
            
            iDigit = num % 10;
            if((Orgnum % iDigit) == 0)
            {
                iCount++;
            }
            num = num/10;
        }
        return iCount;
    }
}