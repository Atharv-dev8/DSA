/*
 * Platform: GeeksforGeeks
 * Problem: Digits in N that Divide it
 * URL: https://www.geeksforgeeks.org/problems/count-digits-in-given-number-n-which-divide-n3331/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Mathematics
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-26T06:33:49.278Z
 */

class Solution {
    public int divisibleByDigits(String s) {
        
        int iDivide =0;
        int iDigit = 0;
        
        int iNumber = Integer.parseInt(s);
        int iOrignal =iNumber;
        while(iNumber!=0)
        {
            iDigit=iNumber%10;
            if((iDigit !=0)&&(iOrignal%iDigit) ==0)
            {
                iDivide++;
            }
            iNumber=iNumber/10;
            
        }
        return iDivide;
   
        
        
    }
}
