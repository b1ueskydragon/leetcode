package leetcode.p0237.alignLeftFromNode;


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) { val = x; }
}

/**
 * You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * The value of each node in the list is unique.
 */
class Solution {
  public void deleteNode(ListNode node) {
    // prev of node
    ListNode prev = null;
    // align value to left
    while (node.next != null) {
      node.val = node.next.val;
      prev = node;
      node = node.next;
    }
    prev.next = null;
  }
}
