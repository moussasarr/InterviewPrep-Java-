class MedianOfTwoSortedArrays{
  //There are two sorted arrays nums1 and nums2 of size m and n respectively.
  //Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  //You may assume nums1 and nums2 cannot be both empty.
  //Ex:
   // nums1 = [1, 3]  nums2 = [2]   The median is 2.0
   // nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5

   //Strategy 1: Brute bruteForce is in T(n) = O(m+n)
   public static double findMedianSortedArrays(int[] num1, int[] num2){
     double median = 0; int n = num1.length, m = num2.length;
      if (n == 0 || num1 == null) median = getMedian(num2); //return num2;
      else if (m == 0 || num2 == null) median = getMedian(num1); //return num1;
      else {
        //Merge Process
        int[] combined = new int[n+m];
        int i = 0, j = 0;

        while(i < n  && j < m){
          if(num1[i] < num2[j]){
            combined[i+j] = num1[i++];
          } else {
            combined[i+j] = num2[j++];
          }
        }

        if(j == m ){
          while(i + j < n + m ) combined[i+j] = num1[i++];
        } else if(i == n){
          while(i + j < n + m ) combined[i+j] = num2[j++];
        }
       median = getMedian(combined);
      }
      return median;
   }

   public static double getMedian(int[] arr){
      int k = arr.length;
      return 0.5*arr[(k-1)/2] + 0.5*arr[k/2];
   }



//Strategy 2: Using binary Seach to get O(log(min(m+n)))
public static double MedianOfTwoSortedArrays(int[] nums1, int[] nums2){
if(nums1 == null || nums1.length < 1) return 0.5*nums2[nums2.length/2] + 0.5*nums2[(nums2.length -1)/2];
if(nums2 == null || nums2.length < 1) return 0.5*nums1[nums1.length/2] + 0.5*nums1[(nums1.length -1)/2];

 int x = nums1.length, y = nums2.length;
 if(y < x){
   return MedianOfTwoSortedArrays(nums2, nums1);
 }
 int left = 0, right = x, partitionX, partitionY;
 while(left <= right){
   partitionX = (left + right)/2;
   partitionY = (x + y + 1)/2 - partitionX;

   int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: nums1[partitionX - 1];
   int minRightX = (partitionX == x) ? Integer.MAX_VALUE: nums1[partitionX];

   int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY -1];
   int minRightY = (partitionY == y) ? Integer.MAX_VALUE: nums2[partitionY];

   if(maxLeftX <= minRightY && maxLeftY <= minRightX){
     if((x + y) % 2 == 0){
       return 0.5*Math.max(maxLeftX, maxLeftY) + 0.5*Math.min(minRightX, minRightY);
     } else {
       return Math.max(maxLeftX, maxLeftY);
     }
   } else if(maxLeftX > minRightY){
     right = partitionX - 1;
   } else {
     left = partitionX + 1;
   }
 }
  return 0.0;
}




   public static void main(String[] args){
     int[] a1 = new int[]{1, 3};  int[] a2 = new int[]{2};
     int[] b1 = new int[]{1, 2};  int[] b2 = new int[]{3, 4};
     int[] a3 = new int[]{2}, b3 = new int[]{1, 3, 4};

     int[] empty = new int[]{};
     System.out.println(findMedianSortedArrays(a2, empty));
     System.out.println(findMedianSortedArrays(b2, empty));
     //int[] res = findMedianSortedArrays(a1, b1);
     //for(int i : res) System.out.println(i);
     System.out.println(findMedianSortedArrays(a1, a2));
     System.out.println(findMedianSortedArrays(a1, b2));
     System.out.println(findMedianSortedArrays(a1, b1));
     System.out.println(findMedianSortedArrays(a3, b3));

     System.out.println("===============================");

     System.out.println(MedianOfTwoSortedArrays(a2, empty));
     System.out.println(MedianOfTwoSortedArrays(b2, empty));
     //int[] res = MedianOfTwoSortedArrays(a1, b1);
     //for(int i : res) System.out.println(i);
     System.out.println(MedianOfTwoSortedArrays(a1, a2));
     System.out.println(MedianOfTwoSortedArrays(a1, b2));
     System.out.println(MedianOfTwoSortedArrays(a1, b1));
     System.out.println(MedianOfTwoSortedArrays(a3, b3));
   }

}
