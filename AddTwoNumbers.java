class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }



public class AddTwoNumbers {
  //Assuming the the addition of the two numbers will not cause overflow when represented by int type
  //Meaning the two numbers are small enough that their addition can be represented with an integer
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = l1.val;
        int base = 1;
        ListNode currentNode = l1.next;
        while(currentNode != null){
            base *= 10;
            num1 += base * currentNode.val;
            currentNode = currentNode.next;
        }

       base = 1;
       int num2 = l2.val;
       currentNode = l2.next;
       while(currentNode != null){
            base *= 10;
            num2 += base * currentNode.val;
            currentNode = currentNode.next;
       }

       Integer addResult = num1 + num2;
       String resultString = addResult.toString();
       int len = resultString.length();
       char[] c = new char[len];

       for(int m = 0; m < len; m++){
         c[m] = resultString.charAt(len - 1 - m);
       }
       resultString = String.valueOf(c);
       addResult = Integer.valueOf(resultString);


       Double d = Math.pow(10, len -1);
       Integer integ = d.intValue();
       ListNode resultNode = new ListNode(addResult/integ);
       int remainder = addResult % integ;
       int val;
        currentNode = resultNode;
       for(int i = len -2; i >= 0; i--){
           d = Math.pow(10, i);
           integ = d.intValue();
           val = remainder / integ;
           currentNode.next = new ListNode(val);
           currentNode = currentNode.next;
           remainder %= Math.pow(10, i);
       }
       return resultNode;
    }

    //Assuming a 32-bit binary addition
    public ListNode add32TwoNumbers(ListNode l1, ListNode l2) {
       int carry = 0;
        int[] a1 = new int[32];
        int[] a2 = new int[32];
        int[] sum = new int[32];

        a1[0] = l1.val;
        a2[0] = l2.val;
        ListNode currentNode1  = l1;
        int k = 1;
        while(currentNode1.next != null && (k <= 31)){
              a1[k] = currentNode1.next.val;
              currentNode1 = currentNode1.next;
              k++;
         }

         currentNode1 = l2;
         k = 1;
         while(currentNode1.next != null && (k <= 31)){
               a2[k] = currentNode1.next.val;
               currentNode1 = currentNode1.next;
               k++;
          }

        sum[0] = (a1[0] + a2[0]) % 10;
        carry = (a1[0] + a2[0])/10;


        int add = 0;

        for(int i = 1; i < 32; i++) {
          add = carry + a1[i] + a2[i];
          sum[i] = add % 10;
          carry =  add / 10;

        }

        int leadingZeros = 0;
        for(int i = 31; i >= 0; i--){
          if(sum[i] != 0){
            break;
          }
          leadingZeros++;
        }

        ListNode resultNode = new ListNode(sum[0]);
        ListNode currentNode = resultNode;
        int resLen = 32 - leadingZeros;
        for(int i = 1; i < resLen; i++){
          currentNode.next = new ListNode(sum[i]);
          currentNode = currentNode.next;
        }
        return resultNode;
    }

    //Assuming a mutli-bit binary addition of integers - We use a carry bit in case of overflow
    public static ListNode addTwoNumbersBinary(ListNode l1, ListNode l2) {

        //Find length of arrays
        int Len1 = 1;
        int Len2  = 1;
        ListNode curr = l1;
        while(curr.next != null){
          Len1 ++;
          curr = curr.next;
        }
        curr = l2;
        while(curr.next != null){
          Len2++;
          curr = curr.next;
        }

        int len = Math.max(Len1, Len2) + 1;

        //Initializing
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        a1[0] = l1.val;
        a2[0] = l2.val;
        int[] sum = new int[len];
        int carry = 0;
        // sum[0] = (a1[0] + a2[0]) % 10;
        // carry = (a1[0] + a2[0]) >= 10 ? 1: 0;



        ListNode currentNode1  = l1;
        int k = 1;
        while(currentNode1.next != null && (k <= Len1 -1)){
              a1[k] = currentNode1.next.val;
              currentNode1 = currentNode1.next;
              k++;
         }

         currentNode1 = l2;
         k = 1;
         while(currentNode1.next != null && (k <= Len2 - 1)){
               a2[k] = currentNode1.next.val;
               currentNode1 = currentNode1.next;
               k++;
          }



        int add = 0;
        int leadingZeros = 1;
        for(int i = 0; i < len; i++) {
          add = carry + a1[i] + a2[i];
          sum[i] = add % 10;
          carry =  add >= 10 ? 1: 0;

          if((i == len -2) && (carry == 1)){
            leadingZeros = 0;
          }
        }

         ListNode resultNode = new ListNode(sum[0]);
         ListNode currentNode = resultNode;
         int resLen = len - leadingZeros;
         for(int i = 1; i < resLen; i++){
           currentNode.next = new ListNode(sum[i]);
           currentNode = currentNode.next;
         }
        return resultNode;
    }

    public static void main(String[] args){
      //2 -> 4 -> 3
      ListNode a1 = new ListNode(2);
      a1.next = new ListNode(4);
      a1.next.next = new ListNode(3);

      //5 -> 6 -> 4
      ListNode a2 = new ListNode(5);
      a2.next = new ListNode(6);
      a2.next.next = new ListNode(4);


      //[9] for a3
      ListNode a3 = new ListNode(9);

      //[1,9,9,9,9,9,9,9,9,9] for a4
      ListNode a4 = new ListNode(1);
      ListNode currNode = a4;
      for(int i = 1; i <10; i++){
        currNode.next = new ListNode(9);
        currNode = currNode.next;
      }

      ListNode res = addTwoNumbersBinary(a3, a4);
      ListNode currentNode = res;
      System.out.println(currentNode.val);
      while(currentNode.next != null){
        System.out.println(currentNode.next.val);
        currentNode = currentNode.next;
      }

      ListNode a5 = new ListNode(5);
      ListNode a6 = new ListNode(5);
      ListNode as = addTwoNumbersBinary(a5, a6);
      currentNode = as;
      System.out.println("======================================================");
      while(currentNode != null){
        System.out.println(currentNode.val);
        currentNode = currentNode.next;
      }

    }


}
