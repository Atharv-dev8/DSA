/*
 * Platform: GeeksforGeeks
 * Problem: Min and Max in Array
 * URL: https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
 * Language: Java
 * Difficulty: Easy
 * Topics: NPCI, Arrays
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-08T19:37:08.498Z
 */

class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            } if(arr[i]<min)
            {
               min = arr[i];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
                result.add(min);
                result.add(max);

                return result;
        
    }
}
