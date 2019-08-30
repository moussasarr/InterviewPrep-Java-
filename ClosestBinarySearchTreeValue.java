/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/
import java.util.Stack;
import java.util.TreeMap;
class TreeNode{
  double val;
  TreeNode left;
  TreeNode right;

  public TreeNode(double val){
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class ClosestBinarySearchTreeValue {
    /*
    Given a Binary Search Tree and a number N,
    the task is to find the smallest number in the binary search tree that is
    greater than or equal to N.
    Print the value of the element if it exists otherwise print -1.
    */
    public static double smallestGreaterThan(double target, TreeNode root){
      Stack<TreeNode> stack = new Stack<>();
      if( root == null ) return -1;

      while( root != null ){
        stack.push(root);
        if(root.val <= target){
          root = root.right;
        } else if(root .val > target){
          root = root.left;
        }
      }


        while(!stack.empty()){
          root = stack.pop();
          if(root.val > target){
            return root.val;
          }
        }

      return -1.0;
    }





    public static void main(String[] args){
       TreeNode root = new TreeNode(8);
       TreeNode a = new TreeNode(5);
       TreeNode b = new TreeNode(12);
       TreeNode c = new TreeNode(3);
       TreeNode d = new TreeNode(6);
       TreeNode e = new TreeNode(10);
       TreeNode f = new TreeNode(14);
       TreeNode g = new TreeNode(9);
       TreeNode h = new TreeNode(11);
       TreeNode i = new TreeNode(13);
       TreeNode j = new TreeNode(15);
       root.left = a;
       root.right = b;
       a.left = c;
       a.right = d;
       b.left = e;
       b.right = f;
       e.left = g;
       e.right = h;
       f.left = i;
       i.left = g;

       System.out.println(smallestGreaterThan(14, root));
    }






    /*We have a binary search tree and a number N. Our task is to find the greatest
     number in the binary search tree that is less than or equal to N.
     Print the value of the element if it exists otherwise print -1.
     */
     // public static double greatestLessThan(double target, TreeNode root){
     //
     // }



}
