/*
 * Platform: GeeksforGeeks
 * Problem: Swap Two Numbers
 * URL: https://www.geeksforgeeks.org/problems/swap-the-numbers/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Samsung, CPP, Java, Operators, python, JavaScript, C#
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-10-26T05:44:18.574Z
 */

import java.util.Scanner;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // code here
        int temp = a;
        a=b;
        b=temp;

        System.out.print(a + " " + b);
    }
}
