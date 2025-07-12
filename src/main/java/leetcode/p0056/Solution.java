package leetcode.p0056;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    static class V1 {

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

    static class V2 {

        public int[][] merge(int[][] intervals) {
            if (intervals.length < 2) {
                return intervals;
            }
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            final var mergedList = mergeAsList(intervals);
            final int[][] mergedArray = new int[mergedList.size()][2];
            int i = 0;
            for (int[] xs : mergedList) {
                mergedArray[i++] = xs;
            }
            return mergedArray;
        }

        private LinkedList<int[]> mergeAsList(int[][] sorted) {
            final var result = new LinkedList<int[]>();
            final int n = sorted.length;
            int[] head = sorted[0];
            result.add(head);
            for (int i = 1; i < n; i++) {
                int[] next = sorted[i];
                if (head[1] < next[0]) {
                    result.add(next);
                } else {
                    final int[] merged = new int[]{head[0], Math.max(head[1], next[1])};
                    // remove obsolete merged array, since it already be merged into the new one
                    result.pollLast();
                    result.add(merged);
                }
                head = result.peekLast();
            }

            return result;
        }

    }

    static class V3 {

        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            final var merged = replaceAndMerge(intervals);
            final int[][] mergedArray = new int[merged.size()][2];
            int i = 0;
            for (int[] xs : merged) {
                mergedArray[i++] = xs;
            }
            return mergedArray;
        }

        // This will modify an original array
        private List<int[]> replaceAndMerge(int[][] sorted) {
            final var result = new ArrayList<int[]>();
            // Since `result` will only append `head`
            // this will be modified
            int[] head = sorted[0];
            for (int i = 1; i < sorted.length; i++) {
                int[] second = sorted[i];
                if (head[1] < second[0]) {
                    result.add(head);
                    head = second;
                } else {
                    // can merge
                    // replace `head` to the new merged one
                    // we need to keep current place at this point,
                    // since still we may modify `head` further in the next loop
                    head[1] = Math.max(head[1], second[1]);
                }
            }
            result.add(head);
            return result;
        }

    }

}
