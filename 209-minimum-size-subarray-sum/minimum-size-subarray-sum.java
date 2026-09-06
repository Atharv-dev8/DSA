class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        /*
        so basically in this question they ask to return min length whose sum is greater than equal to target.
        here we apply concept of sliding window .
        */
        int l =0;
        int sum =0;
        int minlength=Integer.MAX_VALUE; //bcz if we apply it to 0 when we do Math.min it always give 0.

        for(int r=0;r<nums.length;r++)
        {
            sum+= nums[r];
        
            while(sum>=target)
            {
                int length = r-l+1;     //measuring a length
                minlength=Math.min(length,minlength);

                sum-=nums[l];       //removing value at index l from sum
                l++;               //moving l forward
            }
        }
            if(minlength == Integer.MAX_VALUE)      //this statement id here bcz if sum is not >= to target 
            {                                       //then it give Integer.MAX_VALUE that's why
                return 0;
            }
        
        return minlength;
    

    
    }
}