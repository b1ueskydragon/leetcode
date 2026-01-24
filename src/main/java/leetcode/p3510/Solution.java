package leetcode.p3510;

import java.util.PriorityQueue;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        Node prev = new Node(nums[0]);
        // Do not cast to int, use Long#compare.
        final var pq = new PriorityQueue<Tuple>((p1, p2) -> p1.sum == p2.sum ? p1.i - p2.i : Long.compare(p1.sum, p2.sum));

        int decreasing = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                decreasing++;
            }
            Node curr = new Node(nums[i]);
            pq.offer(new Tuple(prev, curr, nums[i - 1] + nums[i], i - 1));
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
        }

        if (decreasing == 0) {
            return 0;
        }

        int operation = 0;
        while (!pq.isEmpty()) {
            if (decreasing == 0) {
                return operation;
            }

            var tuple = pq.poll();
            // Check still adjacent.
            if (tuple.left.next != tuple.right) {
                // object 志向のため node object 比較で十分.
                // 最新情報と pq 情報が一致しないのでこの pq 結果は捨てる (lazy deletion).
                continue;
            }

            Node node = new Node(tuple.sum);

            // leftside of merged node
            if (tuple.left.prev != null && tuple.left.prev.val > tuple.left.val) {
                decreasing--;
            }
            // merged node itself
            if (tuple.left.val > tuple.right.val) {
                decreasing--;
            }
            // rightside of merged node
            if (tuple.right.next != null && tuple.right.val > tuple.right.next.val) {
                decreasing--;
            }

            node.prev = tuple.left.prev;
            node.next = tuple.right.next;

            // 新しく PQ に追加する adjacent sum: 2 patterns
            // now node + new node right
            if (tuple.right.next != null) {
                tuple.right.next.prev = node;
                pq.offer(new Tuple(node, node.next, node.val + node.next.val, tuple.i));
            }
            // now node left + new node
            if (tuple.left.prev != null) {
                tuple.left.prev.next = node;
                pq.offer(new Tuple(node.prev, node, node.prev.val + node.val, tuple.i - 1));
            }

            // Detaching.
            tuple.left.prev = null;
            tuple.right.next = null;
            // Not necessary, but detach.
            tuple.left.next = null;
            tuple.right.prev = null;

            if (node.prev != null && node.prev.val > node.val) {
                decreasing++;
            }
            if (node.next != null && node.val > node.next.val) {
                decreasing++;
            }

            operation++;
        }

        return operation;
    }

    static class Node {
        long val;
        Node prev;
        Node next;

        Node(long val) {
            this.val = val;
        }
    }

    static class Tuple {
        Node left; // a node of nums[i]
        Node right; // a node of nums[i+1]
        long sum; // nums[i] + nums[i+1]
        int i; // i. tie sum 対策.

        Tuple(Node left, Node right, long sum, int i) {
            this.left = left;
            this.right = right;
            this.sum = sum;
            this.i = i;
        }
    }
}
