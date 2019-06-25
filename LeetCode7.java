public class LeetCode7 {
  public static int[] reverse(int x){
    // String s = Integer.toString(x);
    // char[] rev = new char[s.length()];
    // for(int i = 0; i < s.length(); i++){
    //   rev[i] = s.charAt(s.length() - 1 -i);
    // }
    // s = String.valueOf(rev);
    // return Integer.parseInt(s);
    int[] input = new int[32];
    input[31] = 0;
    int abs = Math.abs(x);

    int currBase = 30, remainder = abs;

    for(int i = 30; i >= 0; i--){
      if(remainder >= Math.pow(2, i)){
        input[i] = 1;
        remainder -= Math.pow(2, i);
      } else {
        input[i] = 0;
      }
    }

    

    if(x < 0){
      for(int i = 0; i < 32; i++){
        input[i] = (input[i] == 0) ? 1: 0;
      }

      int carry = (input[0] == 1) ? 1 : 0;
      int input[0] = (carry == 0) ? 1 : 0;

      for(int i  = 1 ; i < 31; i++){
          input[i] = (carry != input[i]) ? 1 : 0;
          carry = ((carry == 1) && (input[i] == 1))? 1: 0;
      }
    }




    return input;
  }


  public static void main(String[] args){
    for(int i : reverse(724)) System.out.print(i);

  }
}
