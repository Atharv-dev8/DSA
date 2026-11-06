class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] Arr = new int[nums.length];
        int i = 0;

        for(i=0;i<n;i++)
        {
            Arr[i * 2] = nums[i];
            Arr[2 * i+1] = nums[i+n];
        }
        return Arr;
    }
}