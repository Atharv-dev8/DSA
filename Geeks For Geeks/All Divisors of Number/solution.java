/*
 * Platform: GeeksforGeeks
 * Problem: All Divisors of Number
 * URL: https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics, Factorization
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-28T18:42:45.308Z
 */

import java.util.Collections;

class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList <Integer> Ans = new ArrayList<>();
        
        for(int iCount = 1;iCount * iCount<=n;iCount++)
        {
            if((n % iCount) == 0)
            {
                Ans.add(iCount);
            
            if((iCount) != (n/iCount))
            {
                Ans.add(n/iCount);
            }
        }
        }
        Collections.sort(Ans);
        return Ans;
    }
}
