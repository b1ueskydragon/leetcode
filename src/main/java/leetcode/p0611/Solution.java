package leetcode.p0611;

import java.util.Arrays;

class Solution {

    static class V2 {

        public int triangleNumber(int[] nums) {
            // To construct a triangle,
            // Sum of lengths of two sides > the length of the remaining side
            Arrays.sort(nums);
            final int n = nums.length;
            // 1000C3 < Integer.MAX_VALUE
            int count = 0;
            // Two pointers; 一番遠い k (= 最大辺 k) を先に fix
            for (int k = n - 1; k >= 2; k--) {
                int i = 0;
                int j = k - 1;
                while (i < j) {
                    // `nums` is sorted ascending
                    if (nums[i] + nums[j] > nums[k]) {
                        // Valid:
                        // Once (i, j, k) is valid,
                        // j, k を fix したまま i を右にずらした区間も全て valid
                        count += j - i;
                        // nums[i] + nums[j] を小さくしてみる
                        j--;
                    } else {
                        // Not valid yet:
                        // Increase the smaller side to raise the nums[i] + nums[j]
                        i++;
                    }
                }
            }
            return count;
        }

    }

    static class V1 {

        public int triangleNumber(int[] nums) {
            // To construct a triangle,
            // Sum of lengths of two sides > the length of the remaining side
            // After sorting, we don't need to search further from "not valid" value
            Arrays.sort(nums);
            final int n = nums.length;
            // 1000C3 < Integer.MAX_VALUE
            int count = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    final int requirement = nums[i] + nums[j] - 1;
                    // Less than or equal to `requirement`: valid,
                    // Greater than the `requirement`: unnecessary to search further
                    // `nums` has already been sorted; to find a target (`requirement`) -> Binary search
                    int l = j + 1;
                    int r = n;
                    int k = binarySearch(l, r, nums, requirement);
                    count += +k - j;
                }
            }
            return count;
        }

        private static int binarySearch(int l, int r, int[] nums, int target) {
            // `target` より小さい値の中で最も大きいものを見つけても OK
            while (l < r) {
                // Left-aligned mid index
                final int m = l + (r - l) / 2;
                // `target` may not exist in `num`
                if (nums[m] <= target) {
                    // Since `m` is left-aligned middle, do not fix `l`
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l - 1;
        }

    }

}
