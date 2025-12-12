package leetcode.p0234.findMid._1;

import leetcode.common.ListNode;

class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode last = head;
    int size = 0;
    while (last.next != null) {
      last = last.next;
      size++;
    }

    ListNode left = head;
    ListNode prev = null;
    ListNode right;

    int m = size / 2;
    while (m > 0) {
      right = left.next;
      left.next = prev;
      prev = left;
      left = right;
      m--;
    }

    right = left.next;

    if (size % 2 == 0) {
      // odd-len nodes
      left = prev;
    } else {
      // even-len nodes
      left.next = prev;
    }

    while (left != null && right != null) {
      if (left.val != right.val) {
        return false;
      }
      left = left.next;
      right = right.next;
    }

    return true;
  }
}
