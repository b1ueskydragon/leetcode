package leetcode.p0812;

class Solution {
    // Return the area of the largest triangle that can be formed by any three different points.
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0d;
        final int n = points.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    maxArea = Math.max(maxArea, calcArea(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea;
    }

    private static double calcArea(int[] p0, int[] p1, int[] p2) {
        final int x0 = p0[0];
        final int y0 = p0[1];
        final int x1 = p1[0];
        final int y1 = p1[1];
        final int x2 = p2[0];
        final int y2 = p2[1];

        // (x2, y2) = (0, 0) の場合, S = 1/2 * (x1 * y0 - x0 * y1)
        // 上記は「外側の square area - 外側の 3 triangles area = 真ん中の triangle area」の式を整理すると得られる
        // そこで実際の (x2, y2) を原点に移動する形で平行移動すると,
        // S = 1/2 * ((x1 - x2) * (y0 - y2) - (x0 - x2) * (y1 - y2))
        // 座標をもとに求めた有向面積のため符号が着くので, 大きさ比較には絶対値で比較する
        return Math.abs(0.5d * ((x1 - x2) * (y0 - y2) - (x0 - x2) * (y1 - y2)));
    }
}
