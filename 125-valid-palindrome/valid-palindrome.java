class Solution {
    public static boolean isPalindrome(String s)
    {
        //we apply two pointer first
        //then applying while loop when pointer cross loop stop
        //question asks us tell it is an pallindrome or not and ignore comma and allaphanumeric character
        //and also conver uppercase character into lower case
        //then we check there is any allaphanumeric character if yes then left++ and right--
        //after that we check the conditions in that we first convert uppercase to lowercase and then check it is equal or not
        //if not equal then return false otherwise true
        int left =0;
        int right = s.length()-1;

        while (left<right) {
           //Character.isLetterOrDigit(...) this is use for ignore space nd commas

            while (left<right && !Character.isLetterOrDigit(s.charAt(left))) 
            {
                    left++;
                
            }   
              while (left<right && !Character.isLetterOrDigit(s.charAt(right))) 
            {
                    right--;
            }
            //Character.toLowerCase(...) this use for converting uppercase or lowercase
           if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
            {
            return false;
            
           }
           left++;
           right--;
        }
        return true;
    }
}