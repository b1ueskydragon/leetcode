package leetcode.p0024;


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
    if (head == null) {
      return head;
    }

    // keep it before disconnecting.
    ListNode prev = new ListNode();
    prev.next = head;
    ListNode res = prev;

    ListNode a = head;
    ListNode b = head.next;

    while (true) {
      prev.next = b;

      if (b == null) {
        prev.next = a;
        break;
      }
      if (b.next == null) {
        a.next = null;
        b.next = a;
        break;
      } else {
        a.next = b.next;
        b.next = a;
      }

      // prepare to next
      prev = a;
      a = a.next;
      b = a.next;
    }

    return res.next;
  }
}
