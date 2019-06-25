import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromicSubstring {
  // First let 's use brute Force
  // two  loops that go in total time of n^2 and
  // And For each of the n^2 iterations,
  // Checking if it is a palindrome takes O(n) time
  //So in total brute force takes T(n) = O(n^3)
  public static String longestPalindrome(String s){
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



  public static String longestPalindrome2(String s){
    int len = s.length(); int charRepeats = 0;

    if(len <= 0) return "" ;
    if(len == 1) return s;

    String result = "";
    HashMap<Character, HashSet<Integer>> repeats = new HashMap<>();

    repeats.put(s.charAt(0), new HashSet<Integer>(0));
    for(int i = 1; i < len; i++){
      if(!repeats.keySet().contains(s.charAt(i))){
        repeats.put(s.charAt(i), new HashSet<Integer>());
      }
      repeats.get(s.charAt(i)).add(i);
    }

    for(int i = 0; i < len; i++){
      int charRepeats = repeats.get(s.charAt(i)).size();
      if( charRepeats > 1){
        for(int i : repeats.get(s.charAt(i))){
          for(int j : repeats.get(s.charAt(j))){
            int 
          }
        }
      }
    }

    return result;
  }


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
  //Let s try starting from the biggest substring

  public static void main(String[] args){
    String pal = "Madam, I'm Adam!";
    String noPal = "Madam, I am Adam!";
    System.out.println(isPalindrome(pal));
    System.out.println(isPalindrome(noPal));

    String s1 = "babad";

    System.out.println(isPalindrome("bab"));
    System.out.println(longestPalindrome(s1));
    // System.out.println(longestPalindrome2("cbbd"));
    // System.out.println(longestPalindrome2("babadada"));
    longestPalindrome2("babadada");

  //   HashMap<Character, Integer> reps1 = longestPalindrome2("cbbd");
  //   HashMap<Character, Integer> reps2 = longestPalindrome2("babadada");

   }


}
