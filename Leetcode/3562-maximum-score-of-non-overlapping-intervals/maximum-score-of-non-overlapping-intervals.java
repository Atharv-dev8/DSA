import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // start
            arr[i][1] = intervals.get(i).get(1); // end
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] chosen = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                chosen[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= 4; j++) {

                // Don't take current interval
                dp[i][j] = dp[i - 1][j];
                chosen[i][j] = new ArrayList<>(chosen[i - 1][j]);

                // Find previous non-overlapping interval
                int left = 0;
                int right = i - 1;

                while (left < right) {
                    int mid = left + (right - left + 1) / 2;

                    if (arr[mid - 1][1] < arr[i - 1][0]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }

                int prev = left;

                long newWeight = dp[prev][j - 1] + arr[i - 1][2];

                List<Integer> newList = new ArrayList<>(chosen[prev][j - 1]);
                newList.add(arr[i - 1][3]);

                Collections.sort(newList);

                if (newWeight > dp[i][j]) {
                    dp[i][j] = newWeight;
                    chosen[i][j] = newList;
                } else if (newWeight == dp[i][j]) {

                    List<Integer> current = chosen[i][j];

                    if (isLexicographicallySmaller(newList, current)) {
                        chosen[i][j] = newList;
                    }
                }
            }
        }

        List<Integer> answer = chosen[n][4];

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}