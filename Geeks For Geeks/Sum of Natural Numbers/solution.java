/*
 * Platform: GeeksforGeeks
 * Problem: Sum of Natural Numbers
 * URL: https://www.geeksforgeeks.org/problems/reverse-coding2452/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-26T05:39:29.260Z
 */

import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int iCnt= 0;
        int iSum =0;
        
        for(iCnt =1;iCnt<=n;iCnt++)
        {
            iSum +=iCnt;
        }
        System.out.println(iSum);
        
    }
}
