import java.util.HashMap;

class LongestNonRepeatingSubstring {

  public static int maxSubLength(String s){
    if((s == null) || (s == "") || (s.equals(new String("")))){
          return 0;
        }
        HashMap<Character, Integer> chars;

        int sLen = s.length();
        int longest = 1;
        for(int i = 0; i < sLen; i++){
            if( (sLen - i <= longest) && (sLen > 2 )){
              return longest;
            }
            chars = new HashMap<>();
            chars.put(s.charAt(i), i);
            for(int j = i + 1; j < sLen; j++){
                if(chars.get(s.charAt(j)) == null){
                    chars.put(s.charAt(j), j);
                    if(sLen == 2){
                        return 2;
                    }
                } else {
                    longest = Math.max(longest, j - i);
                    i = chars.get(s.charAt(j));
                    break;
                }
            }
        }
        return longest;
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
