class Solution {
    public double findMaxAverage(int[] nums, int k) {
      
        int l=0;
        int sum = 0;
        int maxsum =Integer.MIN_VALUE;
        double avg =0;

        for(int r=0; r<nums.length;r++)
        {
            sum += nums[r];
            if (r-l+1 == k) {
                maxsum = Math.max(sum,maxsum);

                avg = (double)maxsum/k ; 
                
                sum -= nums[l];
                l++;

                               
            }
        }
        return avg;
    }
}
    
