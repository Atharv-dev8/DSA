class Solution {
    public String triangleType(int[] nums) {
       
        String sTname = "";
        
        if( (nums[0] +nums[1]>nums[2])  && (nums[0] + nums[2] > nums[1]) && (nums[1] + nums[2] > nums[0]))
        {
            if(nums[0] != nums[1]&& nums[0] != nums[2] && nums[1]  != nums[2])
            {
                sTname = "scalene";
            }
            
            else if(nums[0] == nums[1]&& nums[0] == nums[2])
            {
                sTname = "equilateral";
            }
            else if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2])        
            {
            sTname = "isosceles";
            }
        }
        else
        {
            sTname = "none";
        }
        return sTname;
    }
}