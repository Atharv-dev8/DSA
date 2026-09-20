class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //in this Question they ask to return and int array which store intersection
        //so we first create two hashmap first to store an element of nums1 
        //and second is result in it we store an intersection of both array
        //then first we add all element in set 
        //then we iterate second array to find an intersection element
        //and this element we store in resultnamed hashset
        //Question ask we have to return an integer array
        //so first we create integer array of size result hashset 
        //then we transfer hashset element in ans array
        HashSet <Integer> set =new HashSet<>();
        HashSet <Integer> result = new HashSet<>();
        
        int idx = 0 ;
        for(int i=0; i<nums1.length;i++)
        {
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length; i++)
        {
            if(set.contains(nums2[i]))
            {
                result.add(nums2[i]);
                
            }
        }
        int[] ans = new int[result.size()];
        for(int A : result)     //for each loop (advanced iteration loop)
        {
            ans[idx] = A;
            idx++;
        }
        return ans;
    }
}