/*
 * Platform: GeeksforGeeks
 * Problem: Sum of Odd and Even
 * URL: https://www.geeksforgeeks.org/problems/sum-of-odd-and-even-elements3033/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-26T06:07:06.097Z
 */

class Solution {
    public int[] findSum(int n) {
        int iSeven =0;
        int iSodd = 0;
        int iCnt = 0;
        
        for(iCnt=0;iCnt<=n;iCnt++)
        {
            if((iCnt %2) == 0)
            {
                iSeven+=iCnt;
            }
            else
            {
                iSodd+=iCnt;
            }
        
        
        }
        return new int[]{iSodd,iSeven};
    
        
    }
}
