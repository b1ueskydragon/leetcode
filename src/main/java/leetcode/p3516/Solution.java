package leetcode.p3516;

class Solution {
    public int findClosest(int x, int y, int z) {
        final int d1 = Math.abs(z - x);
        final int d2 = Math.abs(z - y);

        if (d1 == d2) {
            return 0;
        }
        return d1 > d2 ? 2 : 1;
    }
}
