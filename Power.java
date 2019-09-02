class Power {
    //Time Complexity --O(n)
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if( x == 0 || x == 1) return x;
        double pow = 1; int exp = 0;

        if(n > 0){
           while(exp < n){
            pow  *=  x;
            exp += 1;
           }
        } else if (n < 0){
            pow = 1/myPow(x, -n);
        }

        return pow;
   }

   //Recursive solution, Problem becomes that number of stacks is limited
    public static double myPow2(double x, int n){
      if(n == 0) return 1;
      if( x == 0 || x == 1) return x;
      double pow2 = 1;
      if( n > 0)  pow2 = myPow2(x, n/2) * myPow2(x, n-n/2);
      else if(n < 0) pow2 = 1/myPow2(x, -n);
      return pow2;
    }

    //Divide-and-Conquer, which calculates half-power only once
    public static double pow(double x, int n){
      if(n == 0 || x == 1) return 1;
      double temp = pow(x, n/2);
      if(n % 2 == 0) return temp*temp;
      else if( n > 0) return temp*temp*x;
      else return 1/pow(x, -n);
    }




    public static void main(String[] args){
      System.out.println(myPow(5, 10)); //
      System.out.println(myPow(-1, 500));//1
      System.out.println(myPow(-1, 33));//-1
      System.out.println(myPow(44747474, 0));//1
      System.out.println(myPow(64, -2));

      System.out.println("=======+=========");
      System.out.println("SAME SHOULD REPEAT");

      // System.out.println(myPow2(5, 10)); //
      // System.out.println(myPow2(-1, 500));//1
      // System.out.println(myPow2(-1, 33));//-1
      // System.out.println(myPow2(44747474, 0));//1
      // System.out.println(myPow2(64, -2));
      //
      // System.out.println("=======+=========");
      // System.out.println("NEW");
      // System.out.println(myPow2(2.00000, 10));

      System.out.println("=======+=========");
      System.out.println("SAME SHOULD REPEAT");

      System.out.println(pow(5, 10)); //
      System.out.println(pow(-1, 500));//1
      System.out.println(pow(-1, 33));//-1
      System.out.println(pow(44747474, 0));//1
      System.out.println(pow(64, -2));
    }
}
