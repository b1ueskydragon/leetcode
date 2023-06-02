package leetcode.p0234.fastAndSlow._1;

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
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode mid = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      ListNode next = slow.next;
      slow.next = mid;
      mid = slow;
      slow = next;

      // odd size
      if (fast != null && fast.next == null) {
        slow = slow.next;
        break;
      }
    }

    while (slow != null && mid != null) {
      if (slow.val != mid.val) {
        return false;
      }
      slow = slow.next;
      mid = mid.next;
    }
    return true;
  }
}
