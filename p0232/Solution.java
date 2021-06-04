package leetcode.p0232;

import java.util.ArrayDeque;
import java.util.Deque;

// Using only two stacks.
// Only push to top, peek/pop from top, size, and isEmpty operations are valid.
// At most 100 calls will be made to push, pop, peek, and empty.
// All the calls to pop and peek are valid.
class MyQueue {
  private final Deque<Integer> stack1;
  private final Deque<Integer> stack2;

  /** Initialize your data structure here. */
  public MyQueue() {
    stack1 = new ArrayDeque<>();
    stack2 = new ArrayDeque<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    // prepare a stack order to stack2 before push a new element
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }

    // push a newcomer in stack2
    stack2.push(x);

    // reverse a stacked order
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return stack1.pop();
  }

  /** Get the front element. */
  public int peek() {
    return stack1.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack1.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
