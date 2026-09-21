class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at
        // current position whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int rem = num % k;

            long[] newDp = new long[k];

            // Start a new subarray with only num
            newDp[rem] = 1;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                int newRem = (int)((long) r * rem % k);

                newDp[newRem] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}