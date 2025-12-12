package leetcode.p0234.findMid._0;

import leetcode.common.ListNode;

class Solution {
  // O(N) time and O(1) space
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    ListNode x = head;
    int count = 0;
    while (x.next != null) {
      count++;
      x = x.next;
    }

    int mid = (count % 2 == 0) ? count / 2 : (count / 2) + 1;
    int m = mid;
    ListNode j = head;
    while (m > 0) {
      j = j.next;
      m--;
    }

    ListNode i = j;
    // invert only the half.
    // make a circle intentionally if node's count is even.
    while (j != null) {
      ListNode tmp = j.next; // keep it first before disconnecting.
      j.next = i;
      i = j;
      if (tmp == null) {
        break;
      }
      j = tmp;
    }

    while (m < mid) {
      if (head.val != j.val) {
        return false;
      }
      head = head.next;
      j = j.next;
      m++;
    }
    return true;
  }
}
