/*
 * Platform: GeeksforGeeks
 * Problem: All Divisors of Number
 * URL: https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics, Factorization
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-28T18:22:52.431Z
 */

class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList <Integer> Ans = new ArrayList<>();
        
        for(int iCount = 1;iCount<=n;iCount++)
        {
            if((n % iCount) == 0)
            {
                Ans.add(iCount);
            }
        }
        return Ans;
    }
}
