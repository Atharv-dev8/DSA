
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If the next character is also ')',
                // they form a pair.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete the pair.
                    insertions++;
                }

                // We need one '(' for each pair of ')'.
                if (open > 0) {
                    open--;
                } else {
                    // Insert one '(' because no opening bracket exists.
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two ')'.
        insertions += open * 2;

        return insertions;
    }
}
