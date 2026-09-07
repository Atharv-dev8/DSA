class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long[] dp = new long[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            long sum = 1;

            for (int i = 0; i < 26; i++) {
                sum = (sum + dp[i]) % mod;
            }

            dp[index] = sum;
        }

        long ans = 0;

        for (long x : dp) {
            ans = (ans + x) % mod;
        }

        return (int) ans;
    }
}