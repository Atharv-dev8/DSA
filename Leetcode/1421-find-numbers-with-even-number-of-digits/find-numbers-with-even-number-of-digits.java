class Solution {
    public int findNumbers(int[] nums) {
        int iCount =0;
        int iDigit =0;
        int  iCnt = 0;

        for(int i=0;i<nums.length;i++)
        {
            iCount = 0; 
            while(nums[i] !=0)
            {
                iDigit = nums[i]%10;
                iCount++;
                nums[i]= nums[i]/10;
            }
            if((iCount % 2)==0)
            {
                iCnt++;
            }
        }
        return iCnt;
    }
}