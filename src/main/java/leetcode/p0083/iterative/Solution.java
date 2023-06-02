package leetcode.p0083.iterative;

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
  // The list is guaranteed to be sorted in ascending order.
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    final ListNode p = head;

    while (head.next != null) {
      if (head.val != head.next.val) {
        head = head.next;
      } else {
        head.next = head.next.next;
      }
    }

    return p;
  }
}
