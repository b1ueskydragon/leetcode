package leetcode.p0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 * <p>
 * You must use only standard operations of a queue
 * -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 */

class MyStack {

  private final Queue<Integer> queueX;
  private final Queue<Integer> queueY;

  /**
   * Initialize your data structure here.
   */
  public MyStack() {
    queueX = new LinkedList<>();
    queueY = new LinkedList<>();
  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {
    if (queueX.isEmpty() && queueY.isEmpty()) {
      queueX.add(x);
      return;
    }
    if (!queueX.isEmpty() && queueY.isEmpty()) {
      queueY.add(x);
      queueY.add(queueX.poll());
      return;
    }
    if (queueX.isEmpty() && !queueY.isEmpty()) {
      queueX.add(x);
      queueX.add(queueY.poll());
    }
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    if (queueX.isEmpty() && !queueY.isEmpty()) return queueY.poll();
    else if (queueY.isEmpty() && !queueX.isEmpty()) return queueX.poll();
    else throw new RuntimeException("Stack is empty. ");
  }

  /**
   * Get the top element.
   */
  public int top() {
    if (queueX.isEmpty() && !queueY.isEmpty()) return queueY.peek();
    else if (queueY.isEmpty() && !queueX.isEmpty()) return queueX.peek();
    else throw new RuntimeException("Stack is empty. ");
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return queueX.isEmpty() && queueY.isEmpty();
  }
}

