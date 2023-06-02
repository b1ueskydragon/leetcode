package leetcode.p1470.s202302;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = n - 1; i >= 1; i--) {
            int start = n - i;
            int end = start + i;
            for (int j = 0; j < i; j++) {
                swap(nums, start++, end++);
            }
        }
        return nums;
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }
}
