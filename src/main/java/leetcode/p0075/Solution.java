package leetcode.p0075;

class Solution {

    static class V1 {
        public void sortColors(int[] nums) {
            final int[] freq = new int[3];
            for (int num : nums) {
                freq[num]++;
            }
            int i = 0;
            for (int num = 0; num < 3; num++) {
                for (int j = 0; j < freq[num]; j++) {
                    nums[i++] = num;
                }
            }
        }

    }
}
