package leetcode.p3516;

class Solution {

    static class V2 {

        public int findClosest(int x, int y, int z) {
            // |x - z| < |y - z| return 1
            // |x - z| > |y - z| return 2
            // |x - z| = |y - z| return 0
            //
            // In this case, abs can be replaced to square
            //
            // (x - z)^2 < (y - z)^2  return 1
            // (x - z)^2 > (y - z)^2  return 2
            // (x - z)^2 = (y - z)^2  return 0
            final int cond = (x - y) * (x + y - 2 * z);
            if (cond == 0) {
                return cond;
            }
            return cond > 0 ? 2 : 1;
        }

    }

    static class V1 {

        public int findClosest(int x, int y, int z) {
            final int d1 = Math.abs(z - x);
            final int d2 = Math.abs(z - y);

            if (d1 == d2) {
                return 0;
            }
            return d1 > d2 ? 2 : 1;
        }

    }

}
