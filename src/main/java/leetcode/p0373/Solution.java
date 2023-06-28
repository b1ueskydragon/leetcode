package leetcode.p0373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // nums1 and nums2 both are sorted in ascending order
    // find k pairs with the smallest sums
    // also see: merge k sorted list problem
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // both nums1 and nums2 may include 100000 nums
        // 100000 ^ 2 will cause integer overflow
        final long n = nums1.length;
        final long m = nums2.length;

        // min-heap
        // parent is always smaller than its children
        final PriorityQueue<Element> pq =
                new PriorityQueue<>(Comparator.comparingInt(el -> el.num1() + el.num2()));

        // since both nums1 and nums2 are sorted in ascending order
        // initial offering could be
        // nums1[0] + nums2[0], nums1[1] + nums2[0], ... , nums1[k - 1] + nums2[0]
        final long initAtMostK = Math.min(n, k);
        for (int i = 0; i < initAtMostK; i++) {
            pq.offer(new Element(nums1[i], nums2[0], 0));
        }

        final List<List<Integer>> res = new ArrayList<>();
        final long atMostK = Math.min(n * m, k);

        for (int i = 0; i < atMostK; i++) {
            final Element minElement = pq.poll();
            if (minElement == null) {
                return res;
            }
            res.add(List.of(minElement.num1(), minElement.num2()));

            if (minElement.j() < m - 1) {
                // since both nums1 and nums2 are sorted in ascending order
                // try the right adjacent element of nums2
                final int j = minElement.j() + 1;
                pq.offer(new Element(minElement.num1(), nums2[j], j));
            }
        }
        return res;
    }
}

/**
 * num1 is a value of nums1
 * num2 is a value of nums2
 * j is an index of nums2
 */
record Element(int num1, int num2, int j) {
}
