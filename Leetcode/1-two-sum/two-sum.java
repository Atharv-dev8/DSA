class Solution {
    public int[] twoSum(int[] nums, int target) {
     //so Q ask to return an index of array integer its sum is equal to target
     //so we create an hash table in it we store integer of array and its index
     //so the approach is we take an current integer from array subtract it from target
     //and check the answer we get from array if it present then get its index
     
     
      HashMap<Integer,Integer> hm = new HashMap<>();
      
      int find = 0;
    
      for(int i=0; i<nums.length;i++)
      {
        
        find =target-nums[i];

        if(hm.containsKey(find))
        {
            return new int[]{hm.get(find),i};

        }
        hm.put(nums[i],i);  //why we write this line here bcz
                                            /* oif we write it at first then  this happen
                                            Iteration 1: i = 0
                                            Step 1: Store the current number.
                                            hm.put(3, 0);


                                            HashMap:
                                            3 → 0


                                            Step 2: Calculate the required number.
                                            find = 6 - 3 = 3


                                            Step 3: Check whether 3 exists.
                                            hm.containsKey(3)  // true


                                            Step 4: Return the indices.
                                            return new int[]{hm.get(3), 0};


                                            Output:
                                            [0, 0] ❌


                                            But we need [0, 1], because the two elements are at different indices. */

      }
      return new int[]{};
    }
}