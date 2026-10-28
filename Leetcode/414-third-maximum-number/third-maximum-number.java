class Solution {
    public int thirdMax(int[] nums) {
        int iFirst = Integer.MIN_VALUE;
        int iSecond = Integer.MIN_VALUE;
        int iThird = Integer.MIN_VALUE;

        boolean hasFirst = false;
        boolean hasSecond = false;
        boolean hasThird = false;

        for (int i = 0; i < nums.length; i++) {

            // Skip duplicates only if that maximum exists
            if ((hasFirst && nums[i] == iFirst) ||
                (hasSecond && nums[i] == iSecond) ||
                (hasThird && nums[i] == iThird)) {
                continue;
            }

            if (!hasFirst || nums[i] > iFirst) {
                iThird = iSecond;
                hasThird = hasSecond;

                iSecond = iFirst;
                hasSecond = hasFirst;

                iFirst = nums[i];
                hasFirst = true;
            }
            else if (!hasSecond || nums[i] > iSecond) {
                iThird = iSecond;
                hasThird = hasSecond;

                iSecond = nums[i];
                hasSecond = true;
            }
            else if (!hasThird || nums[i] > iThird) {
                iThird = nums[i];
                hasThird = true;
            }
        }
        if(hasThird != true)
        {
            return iFirst;
        }
        return iThird;
        
        
        
        
    }
}