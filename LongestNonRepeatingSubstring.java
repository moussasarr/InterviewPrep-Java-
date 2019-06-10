//LeetCode number #3
import java.util.HashSet;
import java.util.HashMap;
class LongestNonRepeatingSubstring {
  //Strategy 1: Brute Force
  public static int bruteForce(String s){
   if((s == null) || (s == "") || (s.equals(new String("")))) return 0;
   int n = s.length(), maxLen = Integer.MIN_VALUE, curLen, j , i;
   HashSet<Character> hashSet;
   for(i = 0; i < n; i++){
     hashSet= new HashSet<>();
     curLen = 0;
     for(j = i; j < n; j++){
       if(hashSet.contains(s.charAt(j))){
         break;
       }
       hashSet.add(s.charAt(j));
     }
     maxLen = Math.max(maxLen, j - i);
   }
   return maxLen;
  }





  //Takes O(n^2) time and s
  public static int maxSubLength(String s){
    if((s == null) || (s == "") || (s.equals(new String("")))){
         return 0;
       }
       HashMap<Character, Integer> chars;

       int sLen = s.length();  //2
       int longest = 1;
       for(int i = 0; i < sLen; i++){
          if(sLen - i <= longest){
            break;
          }

           //Put the first char in HashMap
           chars = new HashMap<>();
           chars.put(s.charAt(i), i);   //a in hashmap
           int len = 1;
           //Looping through
           for(int j = i + 1; j < sLen; j++){
               if(chars.get(s.charAt(j)) == null){
                   chars.put(s.charAt(j), j);
                   len++; //2
               } else {
                   longest = Math.max(longest, len);
                   i = chars.get(s.charAt(j));
                   break;
               }
           }
           longest = Math.max(longest, len);
       }
       return longest;
   }

  public static void main(String[] args){
    System.out.println(bruteForce("abcabcbb"));
    //Should print 3
    System.out.println(bruteForce("bbbbb"));
    //Should print("1")
    System.out.println(bruteForce("pwwkew"));
    //Should print 3

    System.out.println(bruteForce("pwwkewwwokeee"));
    //Should print
    System.out.println(bruteForce(" "));
    System.out.println(bruteForce(""));
    System.out.println(bruteForce(null));
    System.out.println(bruteForce("au"));
    System.out.println(bruteForce("aab"));
  }

}
