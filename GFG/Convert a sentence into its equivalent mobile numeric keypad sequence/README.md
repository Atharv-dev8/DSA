# Convert a sentence into its equivalent mobile numeric keypad sequence

- Platform: GeeksforGeeks
- Language: string printSequence(string S) { unordered_map<char,string> mp; mp[' '] = "0"; mp['A'] = "2"; mp['B'] = "22"; mp['C'] = "222"; mp['D'] = "3"; mp['E'] = "33"; mp['F'] = "333"; mp['G'] = "4"; mp['H'] = "44"; mp['I'] = "444"; mp['J'] = "5"; mp['K'] = "55"; mp['L'] = "555"; mp['M'] = "6"; mp['N'] = "66"; mp['O'] = "666"; mp['P'] = "7"; mp['Q'] = "77"; mp['R'] = "777"; mp['S'] = "7777"; mp['T'] = "8"; mp['U'] = "88"; mp['V'] = "888"; mp['W'] = "9"; mp['X'] = "99"; mp['Y'] = "999"; mp['Z'] = "9999"; string res = " "; for(auto ch:S){ char uch = toupper(ch); if(mp.count(uch)){ res += mp[uch]; } } return res; }
- Difficulty: Unknown
- Topics: Topic Tags Related Articles, Topic Tags, Hash, Strings, Related Articles
- Runtime: N/A
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1
- Synced: 2026-09-06T20:31:36.135Z

## Problem Description

Given a sentence in the form of a string in uppercase, convert it into its equivalent mobile numeric keypad sequence. Please note there might be spaces in between the words in a sentence and we can print spaces by pressing 0. Example 1: Input: S = "GFG" Output: 43334 Explanation: For 'G' press '4' one time. For 'F' press '3' three times. Example 2: Input: S = "HEY U" Output: 4433999088 Explanation: For 'H' press '4' two times. For 'E' press '3' two times. For 'Y' press '9' three times. For white space press '0' one time. For 'U' press '8' two times. Your Task: You dont need to read input or print anything. Complete the function printSequence() which takes a string as input parameter and returns its equivalent mobile numeric keypad sequence as a string. Expected Time Complexity: O(Length of String) Expected Auxiliary Space: O(Length of String) Constraints: 1 <= Length of String <= 105 Characters of string can be empty space or capital alphabets.

## Explanation

This solution was accepted on GeeksforGeeks using string printSequence(string S) { unordered_map<char,string> mp; mp[' '] = "0"; mp['A'] = "2"; mp['B'] = "22"; mp['C'] = "222"; mp['D'] = "3"; mp['E'] = "33"; mp['F'] = "333"; mp['G'] = "4"; mp['H'] = "44"; mp['I'] = "444"; mp['J'] = "5"; mp['K'] = "55"; mp['L'] = "555"; mp['M'] = "6"; mp['N'] = "66"; mp['O'] = "666"; mp['P'] = "7"; mp['Q'] = "77"; mp['R'] = "777"; mp['S'] = "7777"; mp['T'] = "8"; mp['U'] = "88"; mp['V'] = "888"; mp['W'] = "9"; mp['X'] = "99"; mp['Y'] = "999"; mp['Z'] = "9999"; string res = " "; for(auto ch:S){ char uch = toupper(ch); if(mp.count(uch)){ res += mp[uch]; } } return res; }. The detected topics are Topic Tags Related Articles, Topic Tags, Hash, Strings, Related Articles. Review the synced source file for the implementation details.
