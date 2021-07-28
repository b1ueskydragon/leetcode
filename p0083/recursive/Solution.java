package leetcode.p0083.recursive;


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

    final ListNode next = deleteDuplicates(head.next);

    if (next == null) {
      return head;
    }

    if (head.val == next.val) {
      head.next = head.next.next;
    }

    return head;
  }
}
