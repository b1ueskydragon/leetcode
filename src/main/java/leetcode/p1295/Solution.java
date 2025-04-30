package leetcode.p1295;

class Solution {

    static class V1 {
        // Constraints: 1 <= nums[i] <= 100000
        public int findNumbers(int[] nums) {
            int cnt = 0;
            for (int num : nums) {
                if (num < 10) {
                    continue;
                }
                if (num < 100) {
                    cnt++;
                }
                if (num < 1000) {
                    continue;
                }
                if (num < 10000) {
                    cnt++;
                }
                if (num == 100000) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    static class V2 {
        public int findNumbers(int[] nums) {
            int cnt = 0;
            for (int num : nums) {
                if (isEvenDigit(num)) {
                    cnt++;
                }
            }
            return cnt;
        }

        private static boolean isEvenDigit(int num) {
            int i = 0;
            while (num > 0) {
                i++;
                num /= 10;
            }
            // Equivalent to i % 2 == 0
            return (i & 1) == 0;
        }
    }

}
