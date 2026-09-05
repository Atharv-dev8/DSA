class Solution {
    public int romanToInt(String s) {
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
}