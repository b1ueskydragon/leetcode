package leetcode.p0056;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

class Solution {
    // Constraints: intervals[i] = [start_i, end_i], start_i <= end_i
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            // Nothing to do
            return intervals;
        }

        // Sort by left element first
        Arrays.sort(intervals, Comparator.comparing(xs -> xs[0]));

        final int n = intervals.length;
        // Use List since we don't know the final array size at this point
        Deque<int[]> queue = new ArrayDeque<>();
        Deque<int[]> stack = new ArrayDeque<>();
        // e.g.,
        // Input: [[1,3],[2,6],[8,10],[15,18]]
        // Output: [[1,6],[8,10],[15,18]]
        for (int i = n - 1; i >= 0; i--) {
            stack.push(intervals[i]);
        }
        merge(stack.pop(), stack, queue);

        final int[][] res = new int[queue.size()][2];
        int i = 0;
        for (int[] xs : queue) {
            res[i++] = xs;
        }
        return res;
    }

    private void merge(int[] head, Deque<int[]> tail, Deque<int[]> queue) {
        if (tail.isEmpty()) {
            return;
        }

        // Remove the latest (obsolete) result before update to prevent duplication
        if (!queue.isEmpty()) {
            queue.removeLast();
        }

        int[] second = tail.pop();
        if (head[1] < second[0]) {
            // Cannot merge
            queue.addLast(head);
            queue.addLast(second);
            merge(second, tail, queue);
        } else {
            int[] merged = new int[]{head[0], Math.max(head[1], second[1])};
            queue.addLast(merged);
            merge(merged, tail, queue);
        }
    }
}
