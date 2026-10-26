/*
 * Platform: GeeksforGeeks
 * Problem: Digits in N that Divide it
 * URL: https://www.geeksforgeeks.org/problems/count-digits-in-given-number-n-which-divide-n3331/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Mathematics
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-26T06:46:24.362Z
 */

class Solution {
    public int divisibleByDigits(String s) {
        int iDivide = 0;

        for (int i = 0; i < s.length(); i++) {
            int iDigit = s.charAt(i) - '0';

            if (iDigit == 0) {
                continue;
            }

            int remainder = 0;

            for (int j = 0; j < s.length(); j++) {
                remainder = (remainder * 10 + (s.charAt(j) - '0')) % iDigit;
            }

            if (remainder == 0) {
                iDivide++;
            }
        }

        return iDivide;
    }
}
