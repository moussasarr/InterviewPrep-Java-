 class ReversedDigits {
    public static int reverse(int x) {
      int reversed = 0;
      int temp = 0;

      while (x != 0){
        temp = reversed * 10 + x % 10;

        if( (temp / 10) != reversed ){
          return 0;
        }
        reversed = temp;
        x = x / 10;
      }

      return reversed;
    }


    public static void main(String[] args){
      System.out.println(reverse(0));
      System.out.println(reverse(1));
      System.out.println(reverse(9));
      System.out.println(reverse(10));
      System.out.println(reverse(100));
      System.out.println(reverse(123));
    }
  }
