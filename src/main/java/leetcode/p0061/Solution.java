package leetcode.p0061;

class ListNode {
  int val;

  ListNode next;

  ListNode() {}

  ListNode(int val) { this.val = val; }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    ListNode last = head;
    int n = 1;
    while (last.next != null) {
      last = last.next;
      n++;
    }

    last.next = head;

    int step = n - (k % n);
    while (step > 1) {
      head = head.next;
      step--;
    }

    ListNode first = head.next;
    head.next = null;

    return first;
  }
}
