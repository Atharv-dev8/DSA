class Solution {
    public int[] runningSum(int[] nums) {
        int iSum = 0;
        int i = 0;

        for(i=0;i<nums.length;i++)
        {
            iSum = iSum + nums[i];
            nums[i] = iSum;
        }
        return nums;

         
    }
}