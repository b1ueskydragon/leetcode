package leetcode.p2221;

class Solution {

    static class V2 {

        public int triangularSum(int[] nums) {

            // e.g.,
            // [1, 2, 3, 4, 5]
            // [1+2, 2+3, 3+4, 4+5] (%10 foreach)
            // [1+2+2+3, 2+3+3+4, 3+4+4+5] (%10 foreach)
            // [1+2+2+3+2+3+3+4, 2+3+3+4+3+4+4+5] (%10 foreach)
            // [1+2+2+3+2+3+3+4+2+3+3+4+3+4+4+5]
            // 1 *1 + 2 *4 + 3 *6 + 4 *4 + 5 *1 ...
            // (1,4,6,4,1) ... Pascal's triangle
            // (4C0 + 4C1 + 4C2 + 4C3 + 4C4)
            // nCk = n! / k!(n-k)!

            final int n = nums.length;
            int sum = nums[0]; // == nums[0] * 1

            // e.g.,
            // 4C0 + 4C1 + 4C2 + 4C3 + 4C4
            // = 1 + 4/1 + (4*3)/(2*1) + (4*3*2)/(3*2*1) + (4*3*2*1)/(4*3*2*1)
            //
            // u/d = nCi
            int u = n - 1; // 分子
            int d = 1; // 分母
            for (int i = 1; i < n; i++) {
                // 本当は u/d に %10 さえできれば (note: 割り算には mod 演算子は分配できない)
                // 分配法則で各項に %10 することで sum を常に integer 範囲内に収められる
                sum = (sum + nums[i] * (u / d)) % 10;

                // May exceed Long.MAX_VALUE
                u = u * (n - 1 - i);
                d = d * (i + 1);
            }
            return sum;
        }

    }

    static class V1 {

        public int triangularSum(int[] nums) {
            int sum = 0;
            for (int num : rec(nums)) {
                sum += num;
            }
            return sum;
        }

        private int[] rec(int[] nums) {
            if (nums.length == 1) {
                return nums;
            }
            final int n = nums.length;
            final int[] newNums = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            return rec(newNums);
        }

    }

}
