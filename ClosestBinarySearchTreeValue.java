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
  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

  Note:

  Given target value is a floating point.
  You are guaranteed to have only one unique value in the BST that is closest to the target.
  */
  public static double closestValue(double target, TreeNode root){
    double val1 = smallestGreaterThan(target, root),
           val2 = greatestLessThan(target, root),
           d1 = val1 - target,
           d2 = target - val2;

    //Search for the value in the Binary Search Tree
    while(root != null){
      if(target < root.val){
        root = root.left;
      }
      else if(target > root.val){
        root = root.right;
      }
      else{
        return root.val;
      }
    }

    if(val1 == -1 && val2 != -1) return val2;
    if(val1 != -1 && val2 == -1) return val1;
    return Math.min(d1, d2) == d1 ? val1 : val2;
  }




    /*
    Given a Binary Search Tree and a number N,
    the task is to find the smallest number in the binary search tree that is
    greater than or equal to N.
    Print the value of the element if it exists otherwise print -1.

    Time Complexity: O(log n) and Sapce O(n)
    */
    public static double smallestGreaterThan(double target, TreeNode root){
      Stack<TreeNode> stack = new Stack<>();
      if( root == null ) return -1.0;

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

      TreeNode exampleBs = new TreeNode(13);
        exampleBs.left = new TreeNode(3);
        exampleBs.right = new TreeNode(14);
        TreeNode firstLeft = exampleBs.left;
        TreeNode firstRight = exampleBs.right;

        firstLeft.left = new TreeNode(1);
        firstLeft.right = new TreeNode(4);
        firstRight.right = new TreeNode(18);
        firstLeft.left.right = new TreeNode(2);
        firstLeft.right.right = new TreeNode(12);

       TreeNode twelve = firstLeft.right.right;
       twelve.left = new TreeNode(10);
       twelve.left.right = new TreeNode(11);
       twelve.left.left = new TreeNode(5);

       TreeNode five = twelve.left.left;
       five.right = new TreeNode(8);
       five.right.right = new TreeNode(9);
       five.right.left = new TreeNode(7);
       five.right.left.left = new TreeNode(6);


       //System.out.println(smallestGreaterThan(6, exampleBs));
       System.out.println(closestValue(15.3, exampleBs));

    }

    /*We have a binary search tree and a number N. Our task is to find the greatest
     number in the binary search tree that is less than or equal to N.
     Print the value of the element if it exists otherwise print -1.

     Time compleaxity log(n) time and O(n) space (stack)
     */
     public static double greatestLessThan(double target, TreeNode root){
       if(root == null) return -1.0;
       Stack<TreeNode> stack = new Stack<>();

       while(root != null){
         stack.push(root);
         if(root.val >= target){
           root = root.left;
         } else if(root.val < target){
           root = root.right;
         }
       }

       while(!stack.empty()){
         root = stack.pop();
         if(root.val < target){
           return root.val;
         }
       }

       return -1.0;
     }



}
