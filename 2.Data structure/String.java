import java.util.Stack;
public class Stringleet {

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

    public static boolean isAnagram(String s, String t) 
    {
        //in this question we ask to chech it is anagram 
        //there is simple approach we are using that is frequency if it is anagram then its frequency must be same
        //for that we first compare its size if not same return false else true
        //then create int array for that in that we  store char of abcdef...
        //for that as we know java knows value of abcd means its numeric valeue
        //as a=97,b=98 so on
        //then we apply for loop 
        // we do count frequency like that= in s element we check each element and store that element presency in array means frequency
        //if a comes we do count++ then in array in a column it store 1.after that if a comes again again count++ then in array value stores 2.
        //same like that in t in that we perform action  -- on  presency of element if it is anagram in array all elemnt value is 0.
        //if not it is not anagram
        if (s.length() != t.length()) 
        {
            return false;    
        }
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) 
        {
            count[s.charAt(i) - 'a']++;       //s.charAt(i) - 'a' it gives exact index of that alphabet
            count[t.charAt(i)- 'a']--;    
        }
        for (int i = 0; i < 26; i++) 
        {
            if(count[i]!= 0)
                {
                    return false;
                }    
        }
        return true;
    }
    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        //here we use new concept of stack
        //first we store all string character in ch
        //then we add character(Brackets) in stack 
        //we cannot add closing bracket before opening bracket
        //first we add open bracket for the closing bracket we perform an action like
        //fist add open bracket then check stack is Empty if empty return false bcz we cannot add close bracket first
        //then we see top using peek and store value in top
        //after that we check condition and main topmost bracket have to close first then other
        //we see top most bracket if it does not matches  return false if match then pop thatb bracket using function pop()
        //at last we return stack is empty then we return true if not then false
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);    
        
        if (ch == '(' || ch == '[' || ch == '{') 
            {
                stack.push(ch);
            }
            else
            {
                if (stack.isEmpty())            //we only put opening brackets into the stack.                                         
                {                               //peek() needs something to look at.
                {                               //peek() needs something to look at.
                    return false;               //if we not write this line here so this happen the stack is empty, so there is no top element to look at. Java will throw an exception (EmptyStackException).
                }
                }

                char top = stack.peek();
                if (ch==')' && top != '('
                   || ch==']' && top != '['
                    || ch=='}' && top != '{')
                  {      return false;

                 }
                 stack.pop();
            }
        }
        return stack.isEmpty();     //This gives true or false.
    }
    public static String removeDuplicates(String s) //here we remove whole grp 'abbcdd'-> 'ac'
    {
        // here we want the string that does not have consecutive character in that string like if 'abbcdd'-> 'ac'
        //so first we store chae of string in ch variable
        //then we check if the stack is not empty then check coming ch is not equal to peek char in stack (mean top element is not equal to ch).
        //if yes then pop it else push in stack
        //we have to return string then to convert stack to string we use StringBuilder
        //in that we pop elemnt until stack become empty and store it in sb
        //and make string of it but when we pop elemnt it come in reverse order for that we use reverse function to return string
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
              if (!stack.isEmpty() && stack.peek() == ch)
             {
                stack.pop();    
             } else{
                stack.push(ch);
             } 
        }     
             StringBuilder sb = new StringBuilder();

             while (!stack.isEmpty())       //jo paryant stack empty hot nahi toparyant
             {
                sb.append(stack.pop());
             }
             
          
        return sb.reverse().toString();
    }
    
    public static String removeDuplicates2(String s)        //here we return string 'abbcdee'->'abcde' GFG
    {

        //in this question we use two pointer approach 
        //first we create two pointer then first convert string into array of string
       // we do iandj pointer at same index then apply condition if value at i and valuej not equal then do i++
        //and store value of j in i
        //after that j++ we alway do j++ after this condition   
        //to return string we create new modified string in whichj duplicate element are removed
        int i=0;
        int j=0;
        
        char[] ch = s.toCharArray();
        while (j<ch.length) 
        {
        if (ch[i] != ch[j])
            {   
                i++;
                ch[i] = ch[j];
            }
            j++;
        }
        return new String(ch, 0, i + 1);        //arr    → use this character array
                                                // 0     → start from index 0
                                                //i + 1  → take this many characters
     }

 //same question with new approach
    public static String removeDuplicates3(String s)        //here we return string 'abbcdee'->'abcde'
    {
        //this is same question we solve pervious this is StringBuilder approach
        //here we first create an string builder then go thorugh each element of string and storec that ele in ch
        //after that we check sb.length = 0 at start it is zero then add this ele sb OR check previous element is not equal to ch
        //if not then add in sb
        //and return string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            
 
            if (sb.length() == 0 || sb.charAt(sb.length()-1) !=ch) 
            {
                sb.append(ch);    
            }

        }
        return sb.toString();

    }
    public static String longestCommonPrefix(String[] str)
    {
        //in this question we have to do return longest prefix that all string have
        //we declare first str[0] is our prefix 
        //then go through each String and compare it with prefix
        //if it is not start with prefix then we have to remove char for that prefix 
        //then prefix become shorter if it equal to str[i] then first iteration complete then in prefix the shorter value get store
        //again compare new prefix with str[i] again same if start with then dont change if not short the prefix until str[i].startsWith(prefix)
        String prefix = str[0];
        for (int i = 1; i < str.length; i++)
        {
            while (!str[i].startsWith(prefix)) //when our str[i] start with prefix then loop end
            {
                prefix = prefix.substring(0,prefix.length()-1);   //flower
                                                                  //    ↓                                                                
                                                                // compare with "flow"
                                                                 //   flowe
                                                                // ↓
                                                                //flow again compare with flight-> flo->fl so fl is ptrefix
            }    
        }
        return prefix;
        
    }
    public static String printSequence(String S)        //this is q of GFG
    {
        //in this question we have to ask  printsequence like if we press a it prints 2 if we press b it give 22
        //so we are going to first create an array of strings 
        //then we use concept like we used it  before in anagram question
        //first create an stringbuilder then first apply loop to traverse in string thgen store that char in ch
        //then if user enter ' ' then add 0 in sequence 
        //if user press a then print 0'th index in kepad array
        //and return string
        String[] keypad = {
             "2", "22", "222",
            "3", "33", "333",
            "4", "44", "444",
            "5", "55", "555",
            "6", "66", "666",
            "7", "77", "777", "7777",
            "8", "88", "888",
            "9", "99", "999", "9999"
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) 
        {
            char ch = S.charAt(i);   
            
            if (ch == ' ') 
            {
                sb.append(0);
            }else{
                sb.append(keypad[ch -'A']);
            }
        }
        return sb.toString();

    }

    public static int romanToInt(String s)
    {
        //in this question we have to convert romaninteger into integer
        //first we take current char value using switch
        //then we have to go for nxtchar in that we deal with current's nxt
        //if we get input as IV then we have deal with like if curr<nxt then subtact current from curr
        //else add
        
        int result= 0;
         for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            int current = 0;
            switch (ch)                 //use instead of multiple if else
            {
                case 'I': current = 1; break;
                case 'V': current = 5; break;
                case 'X': current = 10; break;
                case 'L': current = 50; break;
                case 'C': current = 100; break;
                case 'D': current = 500; break;
                case 'M': current = 1000; break;
            }
            if (i<s.length()-1) 
            {
                char nxtchar = s.charAt(i+1);
                int next = 0;
                switch (nxtchar)
                {
                    case 'I': next = 1; break;
                    case 'V': next = 5; break;
                    case 'X': next = 10; break;
                    case 'L': next = 50; break;
                    case 'C': next = 100; break;
                    case 'D': next = 500; break;
                    case 'M': next = 1000; break;
                }    
                if (current < next) //  eg. if we get XIV so first our curr=X and nxt=I so 10<1 false then result = 0+10                         
                {                   //  so then out curr=I and nxt=V so 1<5 true then result = 10-1=9
                    result -= current;  //so then our curr=V there is no nxt then condiytion A will apply result = 9+5=14  
                }else{                   //so answer is 14
                    result += current;
                }
            }else{
                result += current;      //there is no next character because we're at the last character.
            }                            //condition A

        }
        return result;


    }
    public static String printDuplicates(String s)            //Q of gfg
    {
        //in this question we have to return an char with it presency in string
         //so we first create array in that we store frequency of elements
         //then we traverse in that array if we found count[i]>1
         //then we give char+its count
        int[] count = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) 
        {
            if (count[i]>1) 
            {
                char ch =(char)('a'+i);  //(char)=type cast. (char)('a'+i) this line means it convert ('a'+i) in character
                sb.append("['");         //('a'+i) this give an integer value
                sb.append(ch);
                sb.append("'],");
                sb.append(count[i]);    
            }    
        }
        return sb.toString();
    }    


    public static int firstUniqChar(String s) 
    { 
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
    
    

    

        
    
    
    
    
     public static void main(String[] args) {

        // String str = "A man, a plan, a canal: Panama";
        // System.out.println(isPalindrome(str));

        // String str = "()[]{}";
        // System.out.println(isValid(str));

    }
    
}
