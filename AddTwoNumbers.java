public class AddTwoNumbers {

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
        String reversed = "";
       StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(resultString); 

        // reverse StringBuilder input1
       input1 = input1.reverse();
       addResult = (int) input1.IntValue();
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
