import java.util.HashMap;

class LongestNonRepeatingSubstring {

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
  }

  public static void main(String[] args){
    System.out.println(maxSubLength("abcabcbb"));
    //Should print 3
    System.out.println(maxSubLength("bbbbb"));
    //Should print("1")
    System.out.println(maxSubLength("pwwkew"));
    //Should print 3

    System.out.println(maxSubLength("pwwkewwwokeee"));
    //Should print
    System.out.println(maxSubLength(" "));
    System.out.println(maxSubLength(""));
    System.out.println(maxSubLength(null));
    System.out.println(maxSubLength("au"));
    System.out.println(maxSubLength("aab"));
  }

}
