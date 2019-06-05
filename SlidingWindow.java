
public class SlidingWindow {
  //Given an array consisting of n integers,
  //find the contiguous subarray of given length k
  //that has the maximum average value.
  //And you need to output the maximum average value.
  /*   Exple:
          1-) Input array is sorted
            input [10, 20, 30, 40, 50, 60, 70]  , k = 3
            output  50+60+70 = 180

          2-) Input array is not sorrted
            input [5, 1, 13, 40, 10, 20, 10 ], k = 3
            output 70
 */
  public static double maximumAvg(int[] array, int k){
     int n = array.length;
     int currSum = 0;
     int maxSum = Integer.MIN_VALUE;
     for(int i = 0; i < k; i++){
       currSum += array[i];
     }
     maxSum = Math.max(maxSum, currSum);
     //Sliding the window
     for(int j = k; j < n; j++){
       currSum -= array[j-k];
       currSum += array[j];
       maxSum = Math.max(maxSum, currSum);
     }
     return maxSum * 1.0/k;
  }



  public static void main(String[] args){
    int[] in1 = new int[]{ 10, 20, 30, 40, 50, 60, 70 };
    int[] in2 = new int[]{ 5, 1, 13, 40, 10, 20, 10 };
    int k = 3;

    System.out.println(maximumAvg(in1, k));
    System.out.println(maximumAvg(in2, k));
  }
}
