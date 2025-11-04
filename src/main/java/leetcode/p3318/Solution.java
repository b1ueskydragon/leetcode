package leetcode.p3318;

import java.util.PriorityQueue;

class Solution {
    private static final int LIMIT = 51;

    public int[] findXSum(int[] nums, int k, int x) {
        final int n = nums.length;
        final int[] freq = new int[LIMIT];

        final int[] res = new int[n - k + 1];
        int j = 0;

        int l = 0;
        int r = k - 1;
        while (l <= r) {
            freq[nums[l]]++;
            l++;
        }

        while (r < n) {
            res[j++] = computeSectionSum(freq, x);

            // Prepare to the next windonw
            int prevL = r - k + 1;
            freq[nums[prevL]]--;
            r++;
            if (r < n) {
                freq[nums[r]]++;
            }
        }

        return res;
    }

    private static int computeSectionSum(final int[] freq, final int x) {
        final var pq = new PriorityQueue<int[]>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 1; i < LIMIT; i++) {
            pq.offer(new int[]{i, freq[i]});
        }

        int sectionSum = 0;
        for (int i = 0; i < x; i++) {
            final int[] p = pq.poll();
            // number * frequencies
            sectionSum += p[0] * p[1];
        }
        return sectionSum;
    }
}
