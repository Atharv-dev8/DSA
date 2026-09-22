class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //question ask to check ransomnote character is available in magazine
        //so basically i craete two hashmap in first i store ransomnote character
        //and in secong store magazine character
        //then add each character and its frequency
        //then applying for each loop on hm1.keyset()
        //and check ransomnote character available in magazine 
        //for that we write condition if ransomenote freq > magazine freq then return false
        //else return true

        HashMap <Character,Integer> hm1 = new HashMap <>();
         HashMap <Character,Integer> hm2 = new HashMap <>();

        for(int i=0; i<ransomNote.length();i++)
        {
            char ch = ransomNote.charAt(i);  
            hm1.put(ch, hm1.getOrDefault(ch,0)+1);      
        }
        for(int i=0;i<magazine.length();i++)
        {
            char mh = magazine.charAt(i);  
            hm2.put(mh, hm2.getOrDefault(mh,0)+1);    
        }
        for(char key : hm1.keySet())
        {
            if(hm1.get(key) > hm2.getOrDefault(key,0)) //"Do I need more of this character than the magazine has
            {
                return false;
            }
        }
        return true;
        
    }
}