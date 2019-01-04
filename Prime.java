// Able to Check if a number is prime
// Get all prime numbers up a certain range using the Sieve of Erasthostenes


public class Prime {
   public static void main(String[] args) {
     System.out.println(" All prime numbers up to 0");
     printPrimes(0);
     System.out.println("\n");

     System.out.println(" All prime numbers up to 2");
     printPrimes(2);
     System.out.println("\n");

     System.out.println(" All prime numbers up to 10");
     printPrimes(10);
     System.out.println("\n");

     System.out.println(" All prime numbers up to 50");
     printPrimes(50);
     System.out.println("\n");

     System.out.println(" All prime numbers up to 100");
     printPrimes(100);
     System.out.println("\n");
   }

   //Ckeck if a number is Prime
   public static boolean isPrime(int n) {
     for(int divisor = 2; divisor * divisor < n; divisor++) {
       if (n % divisor == 0) {
         return false;
       }
     }
     return true;
   }

   //Print all primes less or equal to n using Sieve of Erasthostenes
   public static void printPrimes (int n) {
     boolean[] prime = new boolean[n+1];
     for(int i = 2; i <= n; i++) {
       prime[i] = true;
     }

     for (int divisor = 2; divisor * divisor <= n ; divisor ++ ) {
        if (prime[divisor]) {
          for( int j = 2*divisor; j <= n; j += divisor ) {
            prime[j] = false;
          }
        }
     }

     for(int i = 2; i <= n; i++) {
       if(prime[i]) {
         System.out.println(" " + i);
       }
     }

   }


}
