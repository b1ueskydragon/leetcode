package leetcode.p0011;

class Solution {
    public int maxArea(int[] height) {
        final int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxSize = getSize(0, n - 1, height);
        // move the point of the lower bar
        // since the direction still has a possibility to meet a higher bar
        while (l < r) {
            maxSize = Math.max(maxSize, getSize(l, r, height));
            if (height[l] < height[r]) {
                l++;
            } else {
                // Note:
                // Simply, moving the right point when both points represent same height
                // However, moving the left point would be also fine,
                // since the size's height is determined by the lower height
                r--;
            }
        }
        return maxSize;
    }

    private int getSize(int l, int r, int[] height) {
        return (r - l) * Math.min(height[l], height[r]);
    }
}
