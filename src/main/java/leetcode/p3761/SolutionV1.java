package leetcode.p3761;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionV1 {
    // 方向性がある.
    // 120 -> 21 OK
    // 21 <- 120 NG
    public int minMirrorPairDistance(int[] nums) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int mun = reverse(nums[i]);
            List<Integer> indices = map.get(mun);
            if (indices == null) {
                continue;
            }
            // i よりは右側の indices の中で最も左側
            // i = 0, indices = [4, 5] -> 4
            // i = 5, indices = [0, 7, 9] -> 7 (forward only なので 0 は除外)
            int j = lowerBoundBS(indices, i);
            if (j <= i) {
                continue;
            }
            // System.out.printf("%s %s %n", i, j);
            best = Math.min(best, j - i);
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private int lowerBoundBS(List<Integer> indices, int i) {
        int l = 0;
        // left-aligned center, 候補は必ず r の上なので won't be exceeded.
        int r = indices.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (indices.get(m) <= i) {
                l = m + 1;
            } else {
                // maybe answer but try to find better one.
                r = m;
            }
        }
        return indices.get(r);
    }

    private int reverse(int d) {
        int ans = 0;
        while (d > 0) {
            ans *= 10;
            ans += d % 10;
            d /= 10;
        }
        return ans;
    }
}
