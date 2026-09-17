class Solution {
        public String longestCommonPrefix(String[] str) {
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
}