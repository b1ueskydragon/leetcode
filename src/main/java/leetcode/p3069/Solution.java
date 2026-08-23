package leetcode.p3069;

class Solution {
    public int[] resultArray(int[] nums) {
        final int n = nums.length;
        final int[] a = new int[n];
        a[0] = nums[0];
        final int[] b = new int[n];
        b[0] = nums[1];
        int aLast = 0;
        int bLast = 0;
        for (int i = 2; i < n; i++) {
            if (a[aLast] > b[bLast]) {
                a[++aLast] = nums[i];
            } else {
                b[++bLast] = nums[i];
            }
        }
        int index = 0;
        for (int i = 0; i <= aLast; i++) {
            nums[index++] = a[i];
        }
        for (int i = 0; i <= bLast; i++) {
            nums[index++] = b[i];
        }
        return nums;
    }
}
