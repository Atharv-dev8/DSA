class Solution {
    public void reverseString(char[] s) {
        //in this Q we have to neverse the char array
        //so basically we use two pointer approach
        //in this we do assign two pointer and do start++ asnd end--
        //and perform operation. 
        int start =0, end = s.length-1;
    while (start<end)
    {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp; 
        start++;
        end--;   
    }   
    }
}