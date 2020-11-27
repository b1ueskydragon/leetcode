package leetcode.p0234;

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
  // O(N) time and O(1) space
  public boolean isPalindrome(ListNode head) {

    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;

    // find middle with two pointers (only `fast` skip two times)
    // invert only the half with `slow`, `tmp`, `prev` pointer
    while (fast != null && fast.next != null) {
      fast = fast.next.next;

      ListNode tmp = slow; // keep it before disconnecting
      slow = slow.next;  // slow only proceeds forward (left to right)

      // move it next before inverting.
      // prev and tmp goes backward (right to left)
      // tmp helps to prevent to make circle
      tmp.next = prev;
      prev = tmp;
    }

    // the number of nodes are odd
    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (slow.val != prev.val) {
        return false;
      }
      slow = slow.next; // ->
      prev = prev.next; // <-
    }

    return true;
  }
}
