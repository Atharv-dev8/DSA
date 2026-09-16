class Solution {
    public int[] twoSum(int[] numbers, int target) {
       //so basically in this question they ask to return index of two number whose sum is equal to target
       //so fiest we apply two pointer approach
       //as we know array is sorted
       //if we get sum == target then we return wndex of that two numbers
       int start=0;
       int last= numbers.length-1 ;
      
        
       while(start<last)
       {
            int sum =numbers[start] + numbers[last];
            if(sum == target)
            {
                return new int[]{start+1,last+1};
            }
            if(sum<target)
            {
                start++;
            }
            if(sum>target)
            {
                last--;
            }
            
       } 
        return new int[]{};     //This return is only there to satisfy Java's compiler; normally your loop should return the answer when sum == target
    }
   
}