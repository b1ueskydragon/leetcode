package leetcode.p3718;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        final boolean[] exist = new boolean[101];
        for (int num : nums) {
            exist[num] = true;
        }
        int i;
        for (i = k; i < 101; i = i + k) {
            if (!exist[i]) {
                return i;
            }
        }
        return i;
    }
}
