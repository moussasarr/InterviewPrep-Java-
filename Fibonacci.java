//Computing the nth Fibonacci number using Dynamic Programming

public class Fibonacci {
  private static long[] store;
  //Using tabulation iterative method
  //Preferred method as less stack levels are required
  //Method becomes inaccurate for big numbers
  //as Fib becomes > Long.MAX_VALUE
  //Is accurate up to computing Fib(92)
  public static long iterativeFib(int n) {
    if(n <= 1){
      return n;
    }
    long[] F = new long[n+1];
    F[0] = 0l; F[1]= 1l;

    for(int i = 2; i <= n; i++){
      F[i] = F[i-1] + F[i-2];
    }
    return F[n];
  }

  //Using memoisation recursive method
  public static long recursiveFib(int n){
    if(n <= 1) {
      return n;
    }

    if(store == null){
      store = new long[n+1];
      store[1] = 1;
    }

    if(store[n] != 0){
      return store[n];
    }

    store[n] = recursiveFib(n-1) + recursiveFib(n-2);
    return store[n];

  }

  public static void main(String[] args){
    System.out.print(recursiveFib(90));
  }

}
