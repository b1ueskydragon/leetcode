package leetcode.p1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static class V2 {

        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // To minimize a distance between adjacent two elements -> Sort.
            Arrays.sort(arr);
            int minDiff = 2_000_000;
            for (int i = 0; i < arr.length - 1; i++) {
                minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
            }

            final List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] == minDiff) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(arr[i + 1]);
                    ans.add(pair);
                }
            }
            return ans;
        }

    }

    static class V1 {

        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // To minimize a distance between adjacent two elements -> Sort.
            Arrays.sort(arr);
            final var pq = new PriorityQueue<Pair>(
                    (p1, p2) -> (p1.diff == p2.diff) ? Integer.compare(p1.head, p2.head) : Integer.compare(p1.diff, p2.diff));
            for (int i = 0; i < arr.length - 1; i++) {
                pq.offer(new Pair(arr[i + 1] - arr[i], arr[i], arr[i + 1]));
            }

            final List<List<Integer>> ans = new ArrayList<>();
            int diff = pq.peek().diff;
            while (!pq.isEmpty()) {
                var pair = pq.poll();
                if (pair.diff > diff) {
                    return ans;
                }
                ans.add(pair.list);
            }
            return ans;
        }

        static class Pair {
            int diff;
            List<Integer> list = new ArrayList<>();
            int head;

            // num1 <= num2
            Pair(int diff, int num1, int num2) {
                this.diff = diff;
                this.list.add(num1);
                this.list.add(num2);
                this.head = num1;
            }
        }

    }

}
