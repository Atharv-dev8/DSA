class Twopointerpublic  {
    
public void _344reverseString(char[] s)
{
    //in this Q we have to neverse the char array
        //so basically we use two pointer approach
        //in this we do assign two pointer and do start++ asnd end--
        //and perform operation.
    int start =0, end = s.length-1;
    while (start<end)
    {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;    
        start++;
        end--;
    }   

}

public static boolean _125isPalindrome(String s)
    {
        //we apply two pointer first
        //then applying while loop when pointer cross loop stop
        //question asks us tell it is an pallindrome or not and ignore comma and allaphanumeric character
        //and also conver uppercase character into lower case
        //then we check there is any allaphanumeric character if yes then left++ and right--
        //after that we check the conditions in that we first convert uppercase to lowercase and then check it is equal or not
        //if not equal then return false otherwise true
        /*left = 0
        right = 4

        Outer condition:

        left < right   // 0 < 4 → true

        So we enter the outer loop.

        Now the inner loop starts changing left:

        left++;
        left++;
        left++;
        ...

        It is possible that left reaches right while skipping characters.

        The outer while will not be checked again until the inner loop finishes.

        That's why we need:

        while (left < right && ...)

        inside it — to stop the inner loop immediately if the pointers meet/cross.
        Simple way to remember

        Outer while
            ↓
        "Can I start another round?"

        Inner while
            ↓
        "While I'm moving the pointer, have I already reached the other pointer?"

        So the outer condition cannot protect the inner loop, because the pointers can change inside the inner loop.
        */
                
        int left =0;
        int right = s.length()-1;

        while (left<right) {
           //Character.isLetterOrDigit(...) this is use for ignore space nd commas

            while (left<right && !Character.isLetterOrDigit(s.charAt(left))) 
            {
                    left++;
                
            }   
              while (left<right && !Character.isLetterOrDigit(s.charAt(right))) 
            {
                    right--;
            }
            //Character.toLowerCase(...) this use for converting uppercase or lowercase
           if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
            {
            return false;
            
           }
           left++;
           right--;
        }
        return true;
    }
public static void _283moveZeroes(int[] nums)
{
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

    /*Start: for line no 174
    i = 0
    j = 0

    [1, 0]
    ↑
    i,j 
    
    nums[j] is 1, so while doesn't run.

    Then i++ happens because of the for loop:

    i = 1
    j = 0

    [1, 0]
    ↑  ↑
    j  i
    */
    if (j<=i)
    {
        j = j+1;     
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
public static int _26removeDuplicatesfromarray(int[] nums)
 {
    //here in this question we have to return unique number
    // so here we start with both pointer from same side
    //and both pointer start from same side with index 1 bcz we already assume 0'th index element is unique
    //then we apply condition in that we say num[ifast] != num[fast-1] means we compare curr element with previous
    //if above condition is true then we store nums of fast in slow  and do slow++ 
    //and at last return slow then it return slow's value means it count slow++.
    
    int slow =1;

    for (int fast = 1; fast < nums.length; fast++) 
    {
        if (nums[fast] != nums[fast-1]) 
        {
            nums[slow] = nums[fast];
            slow++;    
        }   
        
    }
return slow;

 }
public static int _27removeElement(int[] nums, int val)
{
    //same question like previous one(Q26) in this question we have to remove given element from given array
    //so we do start two pointer from one direction and check it is not equalo to value 
    // if not then we store  nums[slow] = nums[fast] and do slow++ 
    //by doing this we skip element that we have to remove.
    int slow =0;
    for (int fast = 0; fast < nums.length; fast++) 
    {
        if (nums[fast] != val) 
        {
            nums[slow] = nums[fast];
            slow++;    
        }
    }
    return slow;
}
public static String _345reverseVowels(String s)
 {
    //so basically in this question we have to swap vowel of string and return that String
    //so first we apply twop pointer on opposite side
    //and convert string to its character's array
    //then create and vowels String
    //then check at start characters is equal to vowel if not then start ++ same with end
    //id equal's then swap and again start++ and end-- 
    int start =0;
    int end = s.length()-1;
    char[] ch = s.toCharArray();
    String vowel = "aeiouAEIOU";

    while(start<end)
    {
        //check condition
      /*indexOf() → character found     → gives its index
        indexOf() → character not found → gives -1 */
        if (vowel.indexOf(ch[start]) == -1) 
        {
            start++;
        }else if(vowel.indexOf(ch[end]) == -1)
        {
                end--;
        }
        else  //swap vowel
        {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;
        }

        
    }
    return new String(ch);  //return updated String
                            //String(ch) this mean create new String using character stored in ch 
        
 }
public int[] _167twoSum(int[] numbers, int target)
 {
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
 













    public static void main(String A[]) {
        
    }
}
