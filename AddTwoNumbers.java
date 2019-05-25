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
         c[i] = resultString.charAt(len - 1 - i);
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

}
