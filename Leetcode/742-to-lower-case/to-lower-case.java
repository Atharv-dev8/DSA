class Solution {
    public String toLowerCase(String s) {
        String LC ="";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
        if(ch>='A' && ch<='Z')
        {
            ch = (char)(ch+32);
        }
            LC = LC+ch;
        }
        return LC;
    }
}