import java.util.HashMap;
import java.util.Arrays;

class TwoSum {
  // Solving Two Sum, a LeetCode Problem. Problem is stated as follows:
  // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  // You may assume that each input would have exactly one solution, and you may not use the same element twice.
  // Example:
  // Given nums = [2, 7, 11, 15], target = 9,
  // Because nums[0] + nums[1] = 2 + 7 = 9,
  // return [0, 1].

   // Solution1: Brute Force runs in O(n^2)
   //When array is not sorted
   public int[] twoSum0(int[] nums, int target) {
     for (int i = 0; i < nums.length; i++) {
          for (int j = i + 1; j < nums.length; j++) {
              if (nums[j] == target - nums[i]) {
                  return new int[] { i, j };
              }
          }
      }
  }

  //Solution2: Improvement Runs in O(n) using a HashMap for constant search
  //when array is not sorted
    public int[] twoSum1(int[] nums, int target) {

       HashMap<Integer, Integer> numsMap = new HashMap<>();

       int len = nums.length;
       for(int i = 1; i < len; i++){
          numsMap.put(nums[i], i);
       }

       for(int k = 0; k <len; k++){
         Integer j = numsMap.get(target - nums[k]);
         if(j != null && j != k){
           return new int[]{k, j };
         }
       }
       return new int[]{ -1, -1};
    }

/***********************************************************************************
************************************************************************************
************************************************************************************
************************************************************************************/
//Two Sum II - Input array is sorted
/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

//Sol1: Brute Force goes in O(n^2) time and O(1) space
public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j <len; j++){
                if(numbers[j] == target - numbers[i]){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{-1, -1};
    }

//Sol2: Using Binary Search goes in O(nlogn) time and O(1) space
public int[] twoSum3(int[] numbers, int target) {
        int k = -1;
        for(int i = 0; i < numbers.length; i++){
            k = Arrays.binarySearch(numbers, target - numbers[i]);
            if(k >= 0 & (i != k)){
                return new int[]{ Math.min(i + 1, k + 1), Math.max(i+1, k+1 )};
            }

        }
        return new int[]{-1, k};
    }

//Sol3: Using a HashMap takes linear complexity in both time and space
public int[] twoSum4(int[] numbers, int target) {
       HashMap<Integer, Integer> numsMap = new HashMap<>();

       int len = numbers.length;
       for(int i = 1; i < len; i++){
          numsMap.put(numbers[i], i);
       }

       for(int k = 0; k <len; k++){
         Integer j = numsMap.get(target - numbers[k]);
         if(j != null && j != k){
           return new int[]{k + 1, j + 1 };
         }
       }
       return new int[]{ -1, -1};

    }

  //Sol4: Achieving Linear Time without using HashMap:

}
