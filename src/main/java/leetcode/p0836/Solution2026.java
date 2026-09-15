package leetcode.p0836;

public class Solution2026 implements Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec1 is always:
        // x-range = [a, b] (width  = b-a)
        // y-range = [c, d] (height = d-c)
        final int a = Math.min(rec1[0], rec1[2]); // x1
        final int b = Math.max(rec1[0], rec1[2]); // y1
        final int c = Math.min(rec1[1], rec1[3]); // x2
        final int d = Math.max(rec1[1], rec1[3]); // y2
        // rec2 is always:
        // x-range = [e, f] (width  = f-e)
        // y-range = [g, h] (height = h-g)
        final int e = Math.min(rec2[0], rec2[2]); // x1
        final int f = Math.max(rec2[0], rec2[2]); // y1
        final int g = Math.min(rec2[1], rec2[3]); // x2
        final int h = Math.max(rec2[1], rec2[3]); // y2

        // Non-overlap cases are obvious.
        if (b <= e) {
            return false;
        }
        if (f <= a) {
            return false;
        }
        if (h <= c) {
            return false;
        }
        if (d <= g) {
            return false;
        }

        // Too many overlap cases.
        return true;
    }
}
