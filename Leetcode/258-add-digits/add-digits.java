class Solution {
    public int addDigits(int num) {
        int iDigit =0;
        int iSum =0;
       
        while(num>9)
        {
            int temp = num;
            iSum =0;

                while(temp!=0)
                {
                    iDigit = temp%10;
                    iSum = iSum + iDigit;
                    temp =temp/10;
                }
                num = iSum;
        }
        return num;
    }
}