class Solution {
    public int removeElement(int[] nums, int val) {
     //same question like previous one(Q26) in this question we have to remove given element from given array
    //so we do start two pointer from one direction and check it is not equalo to value 
    // if not then we store  nums[slow] = nums[fast] and do slow++ 
    //by doing this we skip element that we have to remove.
    int slow =0;
    for (int fast = 0; fast < nums.length; fast++) 
    {
        if (nums[fast] != val) 
        {
            nums[slow] = nums[fast];
            slow++;    
        }
    }
    return slow;
    }
}