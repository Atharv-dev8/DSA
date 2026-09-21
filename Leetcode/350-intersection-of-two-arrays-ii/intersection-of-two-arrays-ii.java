class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //so baically in this Question they ask to return an array with in it store and intersected element of both array
        /* like this
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
         */
         //so first we craete an hashmap to store an element and its appearance (Frequency)
         //and again we create an arraylist to store an element which is intersected element of both array
         //
        
        HashMap <Integer,Integer> hm = new HashMap<>();
        ArrayList <Integer> result = new ArrayList<>();

        //adding element and its Frequency in HashMap
        for(int i=0; i<nums1.length; i++)
        {
            hm.put(nums1[i] ,hm.getOrDefault(nums1[i] , 0) +1);

        }

        //traversingin nums2 array 
        for(int i=0;i<nums2.length;i++)
        {
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i])>0) //containsKey() checks if the number exists, while get() > 0 checks if its frequency is still available.

            //we add intersected element in result named Arraylist
            {
                result.add(nums2[i]);
                
                hm.put(nums2[i] , hm.get(nums2[i]) - 1);/*hm.put(2, 5);  // add → 2:5
                                                            hm.put(2, 3);  // update → 2:3

                                                            So remember:

                                                            put() = add new key OR update existing key's value. */
            }
        }
        //as per Question we have to return answer in array form
        //then we create new  array of size which Arraylist have
        //and add result element in new array that we created
        int[] ans = new int[result.size()]; 
        for(int i=0;i<result.size(); i++)
        {
            ans[i] = result.get(i);
        }
        return ans;
    }
}