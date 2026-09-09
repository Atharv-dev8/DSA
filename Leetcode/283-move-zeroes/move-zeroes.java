class Solution {
    public void moveZeroes(int[] nums) {
          int j=0;

for (int i = 0; i < nums.length; i++) 
{
    /*j < nums.length → checks that j is a valid index.
    If j = 4 and length = 5 → valid, so j++ makes j = 5.
    Now the first if is finished.
    The next if may try nums[5] → ❌ error because index 5 doesn't exist.

    Key point: j < nums.length checks the condition at that particular moment. It doesn't stop j++ from making j become nums.length. */
    //and why while not if
    /*using if
    // Start: [0, 1, 0, 3, 12]

    // Swap 1:
    // i = 0, j = 1
    // [1, 0, 0, 3, 12]

    // Next:
    // i = 1, j = 2
    // nums[j] = 0 → no swap

    // Next:
    // i = 2, j = 3
    // Swap 2:
    // [1, 0, 3, 0, 12]

    // Next:
    // i = 3, j = 4
    // Swap 3:
    // [1, 0, 3, 12, 0]

    // Final:
    // [1, 0, 3, 12, 0] */
    

    /*using while
    // Start: [0, 1, 0, 3, 12]

    // Swap 1:
    // i = 0
    // j moves: 0 → 1
    // [1, 0, 0, 3, 12]

    // Next:
    // i = 1
    // j moves: 1 → 2 → 3
    // Swap 2:
    // [1, 3, 0, 0, 12]

    // Next:
    // i = 2
    // j moves: 3 → 4
    // Swap 3:
    // [1, 3, 12, 0, 0]

    // Final:
    // [1, 3, 12, 0, 0] */
    if(j<=i)
    {
        j =i+1;
    }
    while (j<nums.length && nums[j] == 0) 
    {
        j++;    
    }   
    if (j<nums.length &&nums[i] == 0 && nums[j]!=0) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    } 
}



    }
}