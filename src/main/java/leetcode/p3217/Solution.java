package leetcode.p3217;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode prev = new ListNode(-1); // A dummy head
        ListNode res = prev;
        ListNode curr = head;
        while (curr != null) {
            if (!set.contains(curr.val)) {
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            } else {
                // Skip to append to the prev
                curr = curr.next;
            }
        }
        // If prev.next is already null, that's fine.
        // Else (curr was faster than prev), disconnect the prev from its successor nodes.
        prev.next = null;
        return res.next;
    }
}
