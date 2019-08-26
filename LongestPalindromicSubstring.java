import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromicSubstring {
  // First let 's use brute Force
  // two  loops that go in total time of n^2 and
  // And For each of the n^2 iterations,
  // Checking if it is a palindrome takes O(n) time
  //So in total brute force takes T(n) = O(n^3)
  public static String bruteForce(String s){
    String result = "", substr="";
    int strLen = s.length();
    for(int i  = 0; i < strLen; i++){
       for(int j = i + 1; j <= strLen; j++){
         substr = s.substring(i,j);
         if(isPalindrome(substr)){
           result = substr.length() > result.length() ? substr: result;
         }
       }
    }
    return result;
  }

  //Check if a string s is a palindrome
  // public static String longestPalindrome2(String s){
  //   int len = s.length(); int charRepeats = 0;
  //
  //   if(len <= 0) return "" ;
  //   if(len == 1) return s;
  //
  //   String result = "";
  //   HashMap<Character, HashSet<Integer>> repeats = new HashMap<>();
  //
  //   repeats.put(s.charAt(0), new HashSet<Integer>(0));
  //   for(int i = 1; i < len; i++){
  //     if(!repeats.keySet().contains(s.charAt(i))){
  //       repeats.put(s.charAt(i), new HashSet<Integer>());
  //     }
  //     repeats.get(s.charAt(i)).add(i);
  //   }
  //
  //   for(int i = 0; i < len; i++){
  //     int charRepeats = repeats.get(s.charAt(i)).size();
  //     if( charRepeats > 1){
  //       for(int i : repeats.get(s.charAt(i))){
  //         for(int j : repeats.get(s.charAt(j))){
  //           int
  //         }
  //       }
  //     }
  //   }
  //
  //   return result;
  // }


  //Check if a certain element is a plindrome
  // Meaning if it reads the same forward and backward
  //Takes worst-case time T(n) = O(n) for around n/2 iterations
  private static boolean isPalindrome(String s){
    boolean palindrome = true;
    int strLen = s.length(), i = 0, j = strLen -1;
    s = s.toLowerCase();
    while(i < strLen && j >= 0){
      while(!Character.isLetterOrDigit(s.charAt(i))){ i++; }
      while(!Character.isLetterOrDigit(s.charAt(j))){ j--; }
      if(s.charAt(i++) != s.charAt(j--)){
        palindrome = false;
        break;
      }
    }
    return palindrome;
  }



  //How can we improve the brute Force method ?
  //At best checking if a string is a palindrome takes linear time.
  //Let s try using Dynamic Programming
public static String dynamicProgramming(String s){
  int n = s.length();
  if(n < 2) return s;
  String currentSubstr =  "";
  String longestSubstrPal = s.substring(0, 1);
  boolean[][] pal = new boolean[n][n];

  //DP initialization
  for(int i = 0; i < n ; i++){
    pal[i][i] = true;
    if( (i != n - 1) && (s.charAt(i) == s.charAt(i + 1))){
      pal[i][i+1] = true;
      currentSubstr = s.substring(i, i+2);
      if(currentSubstr.length() > longestSubstrPal.length()){
        longestSubstrPal = currentSubstr;
      }
    }
  }

  //If string length is greater than 2, DP
  for(int d = 2; (n > 2) && (d <= n-1); d++){
    for(int j = 0; j + d < n ; j++){
      currentSubstr = s.substring(j, j+d+1);
      if( pal[j+1][j+d-1] && (s.charAt(j) == s.charAt(j+d))){
        pal[j][j+d] = true;
        if(currentSubstr.length() > longestSubstrPal.length()){
          longestSubstrPal = currentSubstr;
        }
      }
    }
  }
  return longestSubstrPal;
}

  public static void main(String[] args){
    // String pal = "Madam, I'm Adam!";
    // String noPal = "Madam, I am Adam!";
    // System.out.println(isPalindrome(pal));
    // System.out.println(isPalindrome(noPal));
    //
     String s1 = "babad";
     String s2 = "babadada";
    //
    // System.out.println(isPalindrome("bab"));
    // System.out.println(longestPalindrome(s1));
    // // System.out.println(longestPalindrome2("cbbd"));
    // // System.out.println(longestPalindrome2("babadada"));
    // longestPalindrome2("babadada");

  //   HashMap<Character, Integer> reps1 = longestPalindrome2("cbbd");
  //   HashMap<Character, Integer> reps2 = longestPalindrome2("babadada");

     System.out.println(":::::::::::-_----------______________________+");
     //System.out.println(dynamicProgramming("bab"));
     System.out.println(dynamicProgramming(s1));
     System.out.println(dynamicProgramming(s2));

   }


}
