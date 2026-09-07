/*
 * Platform: GeeksforGeeks
 * Problem: Chocolate Distribution Problem
 * URL: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Flipkart, Sorting
 * Runtime: 0.29 s
 * Memory: N/A
 * Synced: 2026-09-07T08:25:37.006Z
 */

class Solution {
    public int findMinDiff(int arr[], int k) {
        int l =0;
                int diff =0;
                int mindiff =Integer.MAX_VALUE;
                Arrays.sort(arr);

                for (int r = 0; r < arr.length; r++) 
                {
                      diff = arr[r]- arr[l];

                      if (r-l+1 == k) 
                      {
                        mindiff = Math.min(diff,mindiff);

                        diff -= arr[l];
                        l++;
                      }
                }
                return mindiff;
        
    }
}
