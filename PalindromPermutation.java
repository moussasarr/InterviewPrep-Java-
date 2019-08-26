// LeettCode 266 -Given a string, determine if a permutation of the string could form a palindrome.
//
// Example 1:
//
// Input: "code"
// Output: false
// Example 2:
//
// Input: "aab"
// Output: true
// Example 3:
//
// Input: "carerac"
// Output: true
import java.util.HashMap;
//Time Complexity O(n) and space complexity O(n)
public class PalindromPermutation {
  public static boolean bruteForce(String s){
    if(s.length < 1) return true;

    boolean isPalindromPermutation = true;
    int len = s.length();
    HashMap<Character, Integer> charMap = new HashMap<>();


     for(int i = 0; i < s.length(); i++){
       Character c = s.charAt(i);
       if(charMap.containsKey(c)){
         charMap.put(c, charMap.get(c) + 1);
       } else {
         charMap.put(c, 1);
       }
     }

     int numOfOnes = 0;
     int currentOccurence = 0;

     for(Character a: charMap.keySet()){
       currentOccurence = charMap.get(a);
       if(currentOccurence % 2 == 1){
         numOfOnes += 1;
       }
       if(numOfOnes > 1){return false; }
    }

    return  isPalindromPermutation;
  }


  public static void main(String[] args){
    String s1 = "code", s2 = "aab", s3 ="carerac";
    System.out.println(bruteForce(s1));
    System.out.println(bruteForce(s2));
    System.out.println(bruteForce(s3));
  }
}
