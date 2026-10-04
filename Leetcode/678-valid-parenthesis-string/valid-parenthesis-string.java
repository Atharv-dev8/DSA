class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } 
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } 
            else { // '*'
                minOpen--;  // '*' acts as ')'
                maxOpen++;  // '*' acts as '('
            }

            if (maxOpen < 0) {
                return false;
            }

            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return minOpen == 0;
    }
}

