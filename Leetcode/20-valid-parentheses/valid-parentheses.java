class Solution {
    public boolean isValid(String s) {

   Stack<Character>stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);    
        
        if (ch == '(' || ch == '[' || ch == '{') 
            {
                stack.push(ch);
            }
            else
            {
                if (stack.isEmpty()) 
                {
                    return false;    
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
        return stack.isEmpty();
    }
}