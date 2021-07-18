package leetcode.p0155.next;

class MinStack {

  private Node head;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    head = null;
  }

  public void push(int val) {
    if (head == null) {
      head = new Node(val, val, null);
      return;
    }
    head = new Node(val, Math.min(val, head.min), head);
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  static class Node {
    private int val;
    private int min; // min at the current stack stage
    private Node next; // link right to left

    private Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
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
