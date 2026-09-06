class Solution {
    public String removeDuplicates(String s) {

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
}