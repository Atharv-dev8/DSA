class Solution {
    public int firstUniqChar(String s) {
        //in this question we have to return first unique elemnt index
        //so we first create array in that we store frequency of elements
        //then check from start when we find first char whose frequency '1' then immediately we return index then loop end
        //otherwise return '-1' when we does not found any unique elemnt like in "aaabb"
        int[] count = new int[26];
       

        for (int i = 0; i < s.length(); i++) 
        {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) 
        {
            if (count[s.charAt(i) - 'a'] == 1) 
            {
                return i;    
            }
        }
        return -1;
        }
    }
