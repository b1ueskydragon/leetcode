package leetcode.p0024.loop;


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

    while (b != null) {
      prev.next = b;
      a.next = b.next;
      b.next = a;

      if (a.next == null) {
        break;
      }

      // prepare to next
      prev = a;
      a = a.next;
      b = a.next;
    }

    return res.next;
  }
}
