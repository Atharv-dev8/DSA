public class Slidingwindowbyme {

    public static int maxsumofsubarrayofsizek(int[] a, int k)
    {   
        int sum =0;
        int l = 0;
        int maxsum = Integer.MIN_VALUE;
       
        for(int r=0; r<a.length;r++)
        {
            sum += a[r];

        if (r-l+1 == k) {

            maxsum = Math.max(maxsum, sum);
            sum -= a[l];
            l++;
        }
        }
        return maxsum;

    
    
    }
    public static int subarraywhosesumisgreaterthanequaltotarget(int[] arr, int target)    //max length only for +ve number
    {
  
        int l= 0;
        int sum = 0;
        int maxlength = 0;

        for(int r=0; r<arr.length;r++)
        {
            sum += arr[r];

            
            while (sum >= target)    //when condition is true then only java enters in loop 
            {
                int length = r-l+1;
                 maxlength = Math.max(length,maxlength);

                sum -= arr[l];
                l++;
            }
           
        }
        return maxlength;

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

      public static double[] avgsubarrsizek(int[]a, int k)
      {
        double[] avg = new double[a.length-k+1];
        int sum = 0;
        int l = 0;
        for (int r = 0; r < avg.length; r++) {
            sum += a[r];
            if (r-l+1 == k) {
                avg[r] =(double)sum/k;
                
                sum -= a[l];
                l++;

            }
        }
        return avg;
      }
    
  
    public static void main(String[] args) {
        //int[] arr = {2,5,-6,4,7,5,1,-3,5};
        //int k = 3;
        //System.out.println(maxsumofsubarrayofsizek(arr,k));
        //System.out.println(avgsubarrsizek(arr,k));
        // int[] arr = {2,5,-5,9};
        // int target = 14;
        // System.out.println(subarraywhosesumisgreaterthanequaltotarget(arr,target));
        int arr[] = {5,2,4,7};
        int k = 3;
        System.out.println(maxAverageofsubarraysofsizeK(arr,k));
    }
}
