package leetcode.p0237.alignOnceAndSkip;

import leetcode.common.ListNode;

/**
 * You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * The value of each node in the list is unique.
 */
class Solution {
  public void deleteNode(ListNode node) {
    // align value to left
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
