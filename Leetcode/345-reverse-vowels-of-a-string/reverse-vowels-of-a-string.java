class Solution {
    public String reverseVowels(String s) {
        //so basically in this question we have to swap vowel of string and return that String
    //so first we apply twop pointer on opposite side
    //and convert string to its character's array
    //then create and vowels String
    //then check at start characters is equal to vowel if not then start ++ same with end
    //id equal's then swap and again start++ and end-- 
    int start =0;
    int end = s.length()-1;
    char[] ch = s.toCharArray();
    String vowel = "aeiouAEIOU";

    while(start<end)
    {
        //check condition
      /*indexOf() → character found     → gives its index
        indexOf() → character not found → gives -1 */
        if (vowel.indexOf(ch[start]) == -1) 
        {
            start++;
        }else if(vowel.indexOf(ch[end]) == -1)
        {
                end--;
        }
        else  //swap vowel
        {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;
        }

        
    }
    return new String(ch);  //return updated String
                            //String(ch) this mean create new String using character stored in ch 
        
        
 
    }
}