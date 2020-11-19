package leetcode.p0024.recursion;

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
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode a = head.next; // keep it before disconnecting
    ListNode b = swapPairs(head.next.next);
    head.next = b;
    a.next = head;
    return a;
  }
}
