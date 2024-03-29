//https://medium.com/@zengruiwang/sliding-window-technique-360d840d5740
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
public class SlidingWindow {
  /***SLIDING WINDOW 1-)
  Given an array consisting of n integers,
  find the contiguous subarray of given length k
  that has the maximum average value.
  And you need to output the maximum average value.
    Exple:
          1-) Input array is sorted
            input [10, 20, 30, 40, 50, 60, 70]  , k = 3
            output  50+60+70 = 180

          2-) Input array is not sorrted
            input [5, 1, 13, 40, 10, 20, 10 ], k = 3
            output 70
 ***/
 //Using Sliding Window Technique, we solve the problem in O(n) time
  public static double maximumAvg(int[] array, int k){
     int n = array.length, currSum = 0, maxSum = Integer.MIN_VALUE;
     for(int i = 0; i < k; i++) { currSum += array[i]; }
     maxSum = Math.max(maxSum, currSum);
     //Sliding the window
     for(int j = k; j < n; j++){
       currSum += array[j] - array[j-k];
       maxSum = Math.max(maxSum, currSum);
     }
     return maxSum * 1.0/k;
  }


/***SLIDING WINDOW 2-) WINDOW MEDIAN USING ARRAYS.SORT
    2. Given an array nums, there is a sliding window of size k which is moving
    from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window
    moves right by one position.
    Your job is to output the median array for each window in the array after sorting it.
***/

    //Total time takes  T(n) = O(nlogn) + O(n)  ---> O(nlogn)
    public static double[] medianSlidingWindow(int[] num, int k){
      //Arrays.sort implementation in Java takes O(nlogn)
      Arrays.sort(num);
     //Output median for each window k in num
      int len = num.length - k + 1, midIndex;
      double[] median = new double[len];
      boolean odd = k % 2 == 1 ? true: false;
      for(int i = 0; i < len; i++){
        //Compute window meadian and insert it into array
        midIndex = (2*i + k - 1)/2;
        if(odd){
          median[i] = num[midIndex]/1.0;
        } else {
          median[i] =  (num[midIndex] +  num[midIndex + 1])/2.0;
        }
      }
      return median;
    }


    /***SLIDING WINDOW 3-) WINDOW MEDIAN ---NOT USING BUILT IN
        2. Given an array nums, there is a sliding window of size k which is moving
        from the very left of the array to the very right.
        You can only see the k numbers in the window. Each time the sliding window
        moves right by one position.
        Your job is to output the median array for each window in the original array.
        Do not built-in methods such as Arrays.sort
    ***/
    // Approach1 : Go through each window, loop (n - k) times,
    // at each loop iteration, sort and then compute the median,
    // T(n) = (n - k)klog(k)  ---- Too  slow

    // Approach2: Go through each window, and maintain the an already sorted array,
        // insert new element and delete old element
        // Deleting old element takes O(k) at worst
        // Inserting an old element takes O(k)
        // This means insertion and deletion combined take O(k)
        // So in total, we are looping (n - k) times and at each iteration, we
        // are performing O(k) executions
        // T(n) = O(k(n-k))
    public static double[] medianOfSlidingWindow(int[] num, int k) {
         int len = num.length - k + 1;
         double[] medians = new double[len];
         int[] currWindow = new int[k];
         //O(k)

         for(int i = 0; i < k; i++) currWindow[i] = num[i];
         Arrays.sort(currWindow);
         medians[0] =  0.5*currWindow[(k -1)/2] + 0.5*currWindow[k/2];
         //O(n-k)
         for(int j = 1; j < len; j++){
           remove(currWindow); //O(k)
           insert(currWindow, num[k+j-1]); //O(1)
           medians[j] =   0.5*currWindow[k/2] + 0.5*currWindow[(k-1)/2];
         }
         return medians;
    }

    private static void remove(int[] currentWindow){
      for(int i = 1; i < currentWindow.length; i++){
        currentWindow[i -1] = currentWindow[i];
      }
    }

    private static void insert(int[] currentWindow, int newItem){
      int currIndex = currentWindow.length-1;
      while(currIndex > 0 &&(newItem < currentWindow[currIndex])){
        currentWindow[currIndex] = currentWindow[currIndex -1];
        currIndex -= 1;
      }
      currentWindow[currIndex] = newItem;
    }



    /* Sliding Window 4:
      Given an array of n positive integers and a positive integer s,
      find the minimal length of a contiguous subarray of which the sum ≥ s.
      If there isn’t one, return 0 instead.

      Approach1: Brute Force
          Find all the subarrays --O(n^2) and for Each subarray
             -use the 2 pointer technique

      */
      // T(n) = O(n^2) at worst
      public static int minSubSum(int[] arr, int s){
        int n = arr.length, minLen = Integer.MAX_VALUE, j, currSum;
        // n iterations
        for(int i = 0; i < n; i++){
          j = i;  currSum = 0;
          //at worst n iterations
          while((currSum < s) && (j < n)){
            currSum += arr[j];
            if(currSum >= s){
              break;
            }
            j++;
          }
          if(j < n) minLen = Math.min(minLen, j - i + 1);
        }
        return minLen < Integer.MAX_VALUE ? minLen: 0;
      }



/* 4. Given a string, find the length of the longest substring T that contains
   at most k distinct characters.

   Example1: [e,c,e,b,a], k = 2
             [ e, c, e]  res = 3

             [e,c,c,b,a], k = 2,
             [e, c, c] res = 3

    */

//Strategy 1: bruteForce
//Go through the array and for each index of the array, use the 2-pointer technique

//Time Complexity Analysis:
  // i loops n times and j loops at worst n times
  // So worst-case time complexity T(n) = O(n^2)
public static int lengthLongestSubstringKDistinct(String s, int k){
  int j = 0, nDistinct= 0, maxLength = 0;
  HashSet<Character> charSet = new HashSet<>();
   for(int i = 0; i < s.length(); i++){
     while(nDistinct <= k){
       if(!charSet.contains(s.charAt(j))){
         if(nDistinct == k){
           break;
         }
         charSet.add(s.charAt(j));
         nDistinct++;
       }
       j++;
     }
     maxLength = Math.max(maxLength, j-i) ;
   }
  return maxLength;
}

//Strategy 2: Using Sliding window technique to improve
public static int longestSubstringKDistinctlen(String s, int k){

}

  public static void main(String[] args){
    int[] in1 = new int[]{ 10, 20, 30, 40, 50, 60, 70 };
    int[] in2 = new int[]{ 5, 1, 13, 40, 10, 20, 10 };
    int[] in3 = new int[]{ 2, 1, 3, 4, 4, 2, 4, 3, 9 };
    int k = 3;

    System.out.println(maximumAvg(in1, k));
    System.out.println(maximumAvg(in2, k));

    double[] med1 = medianSlidingWindow(in1, k);
    for(double d1 : med1) System.out.println(d1);
    System.out.println("================================");

    double[] med2 = medianSlidingWindow(in2, k);
    for(double d2 : med2) System.out.println(d2);


    System.out.println("================================");
    double[] med3 = medianOfSlidingWindow(in3, k);
    for(double d3: med3) System.out.println(d3);

    System.out.println("================================");
    System.out.println(minSubSum(in3, 100));

    System.out.println("================================");
    String s1 = "eceba", s2 = "eccba";
    int n = 2;
    System.out.println(lengthLongestSubstringKDistinct(s1, n));
    System.out.println(lengthLongestSubstringKDistinct(s2, n));

    System.out.println("================================");
    System.out.println(longestSubstringKDistinctlen(s1, n));
    System.out.println(longestSubstringKDistinctlen(s2, n));
  }
}
