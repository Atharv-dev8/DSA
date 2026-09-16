class Solution {
    public int removeDuplicates(int[] nums) {
         //here in this question we have to return unique number
    // so here we start with both pointer from same side
    //and both pointer start from same side with index 1 bcz we already assume 0'th index element is unique
    //then we apply condition in that we say num[ifast] != num[fast-1] means we compare curr element with previous
    //if above condition is true then we store nums of fast in slow  and do slow++ 
    //and at last return slow then it return slow's value means it count slow++.
           int slow =1;

    for (int fast = 1; fast < nums.length; fast++) 
    {
        if (nums[fast] != nums[fast-1]) 
        {
            nums[slow] = nums[fast];
            slow++;    
        }   
        
    }
    return slow;

    }
}