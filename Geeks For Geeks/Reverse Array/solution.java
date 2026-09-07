/*
 * Platform: GeeksforGeeks
 * Problem: Reverse Array
 * URL: https://www.geeksforgeeks.org/problems/reverse-an-array/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Bloomberg, Facebook, TCS, Adobe, Google, Infosys, Capgemini, Morgan Stanley
 * Runtime: 1.17 s
 * Memory: N/A
 * Synced: 2026-09-07T07:47:07.320Z
 */

class Solution {
    public void reverseArray(int arr[]) {
      int start = 0, end = arr.length-1;

            while (start<end) {

                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start ++;
                end --;


            }
        
    }
}
