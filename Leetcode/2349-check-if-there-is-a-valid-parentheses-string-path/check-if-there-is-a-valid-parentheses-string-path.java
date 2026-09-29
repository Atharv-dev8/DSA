class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // dp[r][c][balance]
        boolean[][][] dp = new boolean[m][n][m + n];

        // Starting cell must be '('
        if (grid[0][0] != '(') {
            return false;
        }

        dp[0][0][1] = true;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                for (int balance = 0; balance < m + n; balance++) {

                    if (!dp[r][c][balance]) {
                        continue;
                    }

                    // Move Down
                    if (r + 1 < m) {
                        int newBalance = balance
                                + (grid[r + 1][c] == '(' ? 1 : -1);

                        if (newBalance >= 0) {
                            dp[r + 1][c][newBalance] = true;
                        }
                    }

                    // Move Right
                    if (c + 1 < n) {
                        int newBalance = balance
                                + (grid[r][c + 1] == '(' ? 1 : -1);

                        if (newBalance >= 0) {
                            dp[r][c + 1][newBalance] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}