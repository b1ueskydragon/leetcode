package leetcode.p0002;

class Solution {

    static class V2 {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            final ListNode node = new ListNode(-1); // sentinel
            ListNode head = node;
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {
                int sum = carry;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                carry = sum / 10;
                sum %= 10;
                head.next = new ListNode(sum);
                head = head.next;
            }

            return node.next;
        }

    }

    static class V1 {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            final ListNode node = new ListNode();
            ListNode head = node;
            while (l1 != null || l2 != null) {
                int sum = head.val;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                if (sum >= 10) {
                    head.next = new ListNode(1); // carry
                    sum -= 10;
                }

                head.val = sum;

                if (l1 != null || l2 != null) {
                    if (head.next == null) {
                        head.next = new ListNode(); // without carry
                    }
                    head = head.next;
                }
            }

            return node;
        }

    }

}
