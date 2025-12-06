package leetcode.p3432;

class Solution {

    static class V2 {

        public int countPartitions(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            // odd + odd = even
            // even + even = even
            // 和が even なら (odd, odd), (even, even) pairs しか出て来ない
            // さらに
            // odd - odd = even
            // even - even = even

            // ちなみに odd + even = odd, odd - even = odd なので
            // All pairs or nothing.
            return sum % 2 == 0 ? nums.length - 1 : 0;
        }

    }

    static class V1 {

        public int countPartitions(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int leftSum = nums[0];
            int rightSum = sum - nums[0];
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if ((rightSum - leftSum) % 2 == 0) {
                    ans++;
                }
                leftSum += nums[i];
                rightSum -= nums[i];
            }
            return ans;
        }

    }

}
