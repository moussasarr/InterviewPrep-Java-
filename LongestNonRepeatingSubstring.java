//LeetCode number #3
import java.util.HashSet;
import java.util.HashMap;
class LongestNonRepeatingSubstring {

  //Strategy 1: Using a HashSet to store already encounteered characters
  //T(n) = O(n^2) , HashSet searches in constant time
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

  //Strategy 2: Using Sliding Window technique, combined with HashSet method
  public static int SlidingWindow(String s){
    if((s == null) || (s == "") || (s.equals(new String("")))) return 0;
    int n = s.length(), maxLen = Integer.MIN_VALUE;
    HashSet<Character> hashSet = new HashSet<>();
    int i = 0;
    int j = 0;
    while(i < n && j < n){
      if(!hashSet.contains(s.charAt(j))){
        hashSet.add(s.charAt(j++));
        maxLen = Math.max(maxLen, j - i);
      } else {
        hashSet.remove(s.charAt(i++));
      }
    }
    return maxLen;
    }



  public static void main(String[] args){
    System.out.println(SlidingWindow("abcabcbb"));
    //Should print 3
    System.out.println(SlidingWindow("bbbbb"));
    //Should print("1")
    System.out.println(SlidingWindow("pwwkew"));
    //Should print 3

    System.out.println(SlidingWindow("pwwkewwwokeee"));
    //Should print
    System.out.println(SlidingWindow(" "));
    System.out.println(SlidingWindow(""));
    System.out.println(SlidingWindow(null));
    System.out.println(SlidingWindow("au"));
    System.out.println(SlidingWindow("aab"));
  }

}
