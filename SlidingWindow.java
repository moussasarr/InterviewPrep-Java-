import java.util.Arrays;

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





/***LIDING WINDOW 2-)
    2. Given an array nums, there is a sliding window of size k which is moving
    from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window
    moves right by one position.
    Your job is to output the median array for each window in the original array.
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





  public static void main(String[] args){
    int[] in1 = new int[]{ 10, 20, 30, 40, 50, 60, 70 };
    int[] in2 = new int[]{ 5, 1, 13, 40, 10, 20, 10 };
    int k = 3;

    System.out.println(maximumAvg(in1, k));
    System.out.println(maximumAvg(in2, k));

    double[] med1 = medianSlidingWindow(in1, k);
    for(double d1 : med1) System.out.println(d1);
    System.out.println("================================");

    double[] med2 = medianSlidingWindow(in2, k);
    for(double d2 : med2) System.out.println(d2);


  }
}
