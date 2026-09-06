class Solution {
    public void nextPermutation(int[] nums) {
    //in this que we will use a stratergy which check elements from last
        //find the pair which has right element greater than left(left willbecome pivot)
        //it tells us thst swapping this elements or making changes in right side of this elements
        //will give us next permutation
        //now what changes?
        //we will again find from right a element which is greater than our pivot
        //we will swp that element with pivot as it is the smallest element present in right part(after pivot)
        //now we will reverse the array after pivot as the current sturcture is in descending order
        //i.e larger number first
        //we will get elements in asscending ordr i.e. smallest element
        //which we needfor next permutation
        //first lop for finding pivot element
        for (int i = nums.length-1; i>0; i--) 
        {
            if (nums[i-1]<nums[i]) {
                int s =0;           //s will store the index of the successor

                //this loop for finding succesor element i.e first greater element than pivot
                for (int j = nums.length-1; j>=i; j--) 
                {
                    if (nums[j]>nums[i-1]) 
                    {
                        s=j; 
                        break;   
                    }    
                }
                //swap successor and pivot
                int temp = nums[i-1];
                nums[i-1]=nums[s];
                nums[s] = temp;

                //reverse the array from pivot+1 till end
                int r = nums.length-1;
                while (i<r) 
                {
                    int mp = nums[r];
                    nums[r] =nums[i];
                    nums[i] = mp;
                    i++;
                    r--;
                }
                break;
            } 
            //if we on last permutation just reversing the whole array
            
            else if (i==1) 
            {
                int k=nums.length-1;
                int p =i-1;
                while (p<k) 
                {
                    int var = nums[k];
                    nums[k] = nums[p];
                    nums[p] = var;
                    p++;
                    k--;
                        
                }    
            }   
        }
        
    }
}