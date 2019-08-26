import java.util.Stack;

public class MinStack {
  private static Stack<Integer> minimum;
  private static Stack<Integer> mainStack;

  /** initialize your data structure here. */
  public MinStack() {
      minimum = new Stack<Integer>();
      mainStack = new Stack<Integer>();
  }

  public static void push(int x) {

      if( minimum.empty() || x <= minimum.peek().intValue()){
          minimum.push(x);
      }
      mainStack.push(x);
  }

  public static void pop() {
      if(!mainStack.empty() && !minimum.empty() && (mainStack.peek().intValue() == minimum.peek().intValue())){
          minimum.pop();
      }
      mainStack.pop();
  }


  public static int top() {
      return mainStack.peek();
  }

  public static int getMin() {
      return minimum.peek();
  }

  public static void main(String[] args){
      MinStack minstack = new MinStack();
      minstack.push(512);
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.push(-1024);
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.push(-1024);
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.push(512);
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.pop();
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.getMin();
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.pop();
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());

      minstack.getMin();
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());


      minstack.pop();
      System.out.println(minstack.top());
      System.out.println(minstack.getMin());


      //System.out.println(minstack.getMin());
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
