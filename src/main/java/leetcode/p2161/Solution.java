package leetcode.p2161;

class Solution {
    // TO-BE: [less than pivot] + [pivots] + [greater than pivot]
    // and maintain original order as possible as we can
    public int[] pivotArray(int[] nums, int pivot) {
        final int n = nums.length;
        final int[] ls = new int[n];
        int x = 0;
        final int[] ps = new int[n];
        int y = 0;
        final int[] gs = new int[n];
        int z = 0;
        for (int num : nums) {
            if (num < pivot) {
                ls[x++] = num;
            } else if (num == pivot) {
                ps[y++] = num;
            } else {
                gs[z++] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i < x) {
                nums[i] = ls[i];
                continue;
            }
            if (i < x + y) {
                nums[i] = ps[i - x];
                continue;
            }
            nums[i] = gs[i - x - y];
        }
        return nums;
    }
}
