public class BinarySearch {

  //Iterative Binary Binary search
  //returns -1 if not found
  //Result is accurate when input array is sorted
  // Best when the size of the array is extremely large as
  // there are a limited number of stack levels
  public static int iterativeMethod(int[] a, int item){
    int low = 0;
    int high = a.length - 1;

    while(low <= high){
      int mid = (low + high)/2;
      if (item < a[mid]) {
        high = mid - 1;
      }5
      else if (item > a[mid]) {
        low = mid + 1;
      }
      else {
        return mid;
      }
    }
    return -1;
  }


  private static int bsearch_procedure(int low, int high, int item, int[] array) {
     if( low > high ) {
       return -1;
     }

     int middle = (low + high)/2;
     if (item < array[middle]) {
        return bsearch_procedure(low, middle - 1, item , array);
      }
      else if (item > array[middle]){
        return bsearch_procedure(middle + 1, high, item, array);
      }
      else {
        return middle;
      }
  }


  public static  int recursive_method(int[] a, int item) {
      int length = a.length;
      int left = 0;
      int high = a.length - 1;

      if(length <= 0){
        return -1;
      }

      return bsearch_procedure(left, high, item, a);

  }




  public static void main(String[] args){

    //Testing our iterative BSearch method
    int[] b = new int[]{ 3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62 };
    System.out.println(iterativeMethod(b, 3));
    System.out.println(iterativeMethod(b, 62));
    System.out.println(iterativeMethod(b, 12));
    System.out.println(iterativeMethod(b, 53));
    System.out.println(iterativeMethod(b, 29));
    System.out.println(iterativeMethod(b, 200));
    System.out.println(iterativeMethod(b, 2));

    System.out.println("Trying the recursive method now...Result should be the same");

    System.out.println(recursive_method(b, 3));
    System.out.println(recursive_method(b, 62));
    System.out.println(recursive_method(b, 12));
    System.out.println(recursive_method(b, 53));
    System.out.println(recursive_method(b, 29));
    System.out.println(recursive_method(b, 200));
    System.out.println(recursive_method(b, 2));

    System.out.println("Testing with one element arrays");
    int[] c = new int[]{2};
    System.out.println(iterativeMethod(c, 2));
    System.out.println(recursive_method(c, 2));
    System.out.println(iterativeMethod(c, 3));
    System.out.println(recursive_method(c, 3));

    System.out.println("Testing with empty arrays");
    int[] d = new int[]{};
    System.out.println(iterativeMethod(d, 3));
    System.out.println(recursive_method(d, 3));


  }


}
