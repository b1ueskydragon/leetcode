package leetcode.p2099;

import java.util.PriorityQueue;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        final int n = nums.length;
        // [num, index]
        final var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // 一定基準を満たす k 個の数字を常に保持する
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 注意: 先に offer して溢れたら poll する
            // 順番逆だと本来保持すべきものを除去する恐れあり
            if (pq.size() > k) {
                // min heap から poll することで目的 (e.g., 最小) の値が引ける (除去できる)
                pq.poll();
            }
        }
        // この時点では大きい数字上位 k 個が pq に入っている
        final var indexPq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        while (!pq.isEmpty()) {
            indexPq.offer(pq.poll());
        }
        int[] res = new int[k];
        int i = 0;
        while (!indexPq.isEmpty()) {
            res[i++] = indexPq.poll()[0];
        }
        return res;
    }
}
