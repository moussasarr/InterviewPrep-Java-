//LeetCode Problem #21
//Merging 2 sorted singly-linked lists

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class MergeSortedLists {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if ((l1 == null) && (l2 == null)){ return null; }
    else {
        if(l1 == null){ return l2; }
        if(l2 == null){ return l1; }
     }
     boolean comp = (l1.val <= l2.val);
     ListNode currentNode = comp ? l1: l2;
     ListNode otherNode = (currentNode == l1) ? l2: l1;
     ListNode resNode = currentNode;
     ListNode prev = currentNode;
     currentNode = currentNode.next;

     while(currentNode != null){
       if (currentNode.val <= otherNode.val ){
         prev = currentNode;
         currentNode = currentNode.next;
       } else {
         prev.next = otherNode;
         otherNode = currentNode;
         currentNode = prev.next.next;
         prev = prev.next;
       }
     }
     prev.next = otherNode;
    return resNode;
   }










  public static void main(String[] args){
    ListNode a1 = new ListNode(1);
    a1.next = new ListNode(3);
    a1.next.next = new ListNode(9);
    a1.next.next.next = new ListNode(10);

    ListNode a2 = new ListNode(2);
    a2.next = new ListNode(4);
    a2.next.next = new ListNode(5);
    a2.next.next.next = new ListNode(6);


   ListNode merged = mergeTwoLists(a1, a2);
   System.out.println(merged.val);

   ListNode current = merged.next;
   while(current != null){
     System.out.println(current.val);
     current = current.next;
   }

  }
}
