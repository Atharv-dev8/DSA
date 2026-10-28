/*
 * Platform: GeeksforGeeks
 * Problem: Mean or Average of Array
 * URL: https://www.geeksforgeeks.org/problems/mean0021/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-28T18:10:39.875Z
 */

class Solution {
    public static int findMean(int[] arr) {
        int iTotal=arr.length;
        int iSum = 0;
        
        for(int i=0;i<arr.length;i++)
        {
            iSum = iSum+arr[i];
        }
        return iSum/iTotal;
    }
};
