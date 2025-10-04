package leetcode.p0011;

class Solution {
    public int maxArea(int[] height) {
        // find the max (distance x shorter height)
        int i = 0;
        int j = height.length - 1;
        // 10^5 * 10^4 < Integer.MAX_VALUE
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            // When heights are equal ... move i or j either is fine.
            // Even if the exploration path differs, the optimal result is still guaranteed,
            // due to the longer side is always fixed.
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
