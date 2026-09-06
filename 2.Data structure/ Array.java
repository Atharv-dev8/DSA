import java.util.*;
import java.util.HashSet;


public class Arr {
    public static void print(int marks[]){
        for(int i=0;i<marks.length; i++){
            System.out.print(marks[i]+" ");
        }
    }
     public static void update(int marks[]) {
         for(int i=0; i<marks.length;i++){
            marks[i] = marks[i] * marks[i];
         }
  }
    public static void add(int a[],int b[]){
        for(int i=0; i<a.length;i++){
            a[i]= a[i]+ b[i];
        }

    }
    public static int linearsearch(int arr[],int target){
        for(int  i=0;i<arr.length-1;i++){
            if (arr[i] == target) {
                return i;
                
            }
        }
        return-1;
    }
    public static int binarysearch(int arr[],int target){
        int  start = 0;
        int  end = arr.length-1;
        int mid;

        while (start<end) {

            mid = (start + end) /2 ;

            if (target<arr[mid]) {
                end = mid-1;
                
            }
            if (target>arr[mid]) {
                start = mid+1;
                
            }
            if (arr[mid]==target) {
                return mid;
            }
        }
        return-1;
    }
    public static int searchinrotatedsortedarr(int arr[],int target){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start<=end) {
            mid =start +(end-start)/2;
            if(arr[mid]==target) return mid;
            if (arr[mid]>=arr[start]) {
                //left sorted
                if (target<arr[mid] && arr[start]>=target) {
                    //target is in sorted part
                    end = mid-1;
                }else{
                    //target in unsorted part
                    start = mid + 1;

                }
                
            }else{
                //otherwise it is right sorted
                if (target>arr[mid] && target<=arr[end]) {
                    //target is in sorted part
                    start = mid + 1;
                    
                }else{
                    //target is in unsorted part
                    end = mid-1;
                    
                }
            }
            
            
        }
        return-1;
    }

    public static void reversearray(int arr[]){
            int start = 0, end = arr.length-1;

        while (start<end) {

            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start ++;
            end --;

            
        }

    }

    public static int Max_subarraysum(int arr[]){

        int sum = 0 ;
        int max = arr[0];

        for(int i = 0 ; i<arr.length ; i++){
            sum = sum + arr[i];

            if (sum > max) {
                max = sum;
                
            }
            if (sum < 0) {
                sum = 0;
                
            }
        }
        return max;
    }

    public static int besttimetobuyandsellstock(int[] arr){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int i = 0; i<arr.length; i++){
            if (arr[i]<minprice) {
                minprice = arr[i];
                
            }else if (arr[i] - minprice > maxprofit) {
                maxprofit = arr[i] - minprice;                
            }
        }
        return maxprofit;
    }
    public static boolean containsduplicateelement(int[] arr){
        HashSet<Integer>  set = new HashSet<>();

        for (int ar : arr){
            
            if (set.contains(ar)) {
                return true;
                
            }   
            set.add(ar);
        }
        return false;



    }
          
    public static int[] productofrrayexceptitself(int[] nums)
    {
        int[] answer = new int[4];

        int prefix = 1;

        for(int i=0; i<nums.length;i++)
        {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];

        }
        return answer;
 }
    public static double maxAverageofsubarraysofsizeK(int [] arr, int k)
    {
        int l=0;
        int sum = 0;
        int maxsum =Integer.MIN_VALUE;
        double avg =0;

        for(int r=0; r<arr.length;r++)
        {
            sum += arr[r];
            if (r-l+1 == k) {
                maxsum = Math.max(sum,maxsum);
                avg = (double)maxsum/k ; 
                
                sum -= arr[l];
                l++;

                
                               
            }
        }
        return avg;
    } 

    public static   int removeDuplicates(int[] nums)    //it return unique elements
    {
        //we do iandj pointer at same index then apply condition if value at i and valuej not equal then do i++
        //and store value of j in i
        //after that j++ it alway do j++ after this condition  
        //we return i+1 bcz i is only shrink whwn it have unique element thats why we return i+1 it give how many un ique element have there
        int i= 0;
        int j =0;
       
        while (j<nums.length)   
        {
            if (nums[i] != nums[j]) 
            {
                i++;
                nums[i] = nums[j];       
            }
            j++;
            
        }
        return i+1;
    } 

    public static void nextPermutation(int[] nums) 
    {
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






    
        






    public static void main(String[] args) {
        // int marks[] = {95,74,88,98,99};
        // print(marks);
        // update(marks);
        // System.out.println("");
        // print(marks);
           // int a[] ={6,7,0,1,2,3,4,5,6};
            
            // int t =6;
            // int pos = linearsearch(a,t);
            // print(a);
            // update(a);
            // System.out.println("");
            // add(a,a);
            // print(a);

            // System.out.println(binarysearch(a,t));

            // System.out.println(pos);

            //System.out.print(searchinrotatedsortedarr(a,t));
            
            // reversearray(a);
            // for(int i = 0; i<a.length; i++){
            //     System.out.print(a[i] + " ");

            // System.out.println(Max_subarray(a));
 
            // System.out.println(besttimetobuyandsellstock(a));

           // System.out.println(containsduplicateelement(a));
           int ans[] = {1,2,3,4};
           int[] result = productofrrayexceptitself(ans);
           for(int i=0;i<result.length;i++)
           {
            System.out.print(result[i] +" ");
           }
            
          }
        }
