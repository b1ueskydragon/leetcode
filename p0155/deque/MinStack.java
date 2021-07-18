package leetcode.p0155.deque;

import java.util.LinkedList;

class MinStack {

  private final LinkedList<Node> nodes;

  private int min;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    nodes = new LinkedList<>();
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    min = Math.min(min, val);
    nodes.addLast(new Node(val, min));
  }

  public void pop() {
    nodes.removeLast();
    min = (nodes.isEmpty()) ? Integer.MAX_VALUE : nodes.getLast().min;
  }

  public int top() {
    return nodes.getLast().val;
  }

  public int getMin() {
    return this.min;
  }

  static class Node {
    private int val;
    private int min; // min at the current stack stage

    private Node(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
