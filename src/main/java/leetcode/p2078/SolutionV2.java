package leetcode.p2078;

class SolutionV2 implements Solution {

    public int maxDistance(int[] colors) {
        // e.g.,
        // [4,4,4,11,4,4,11,4,4,4,4,4]
        //  ^             ^
        //  or
        // [4,4,4,11,4,4,11,4,4,4,4,4]
        //        ^                 ^
        final int n = colors.length;
        int best = 0;

        // the fixed-rightmost to the leftmost
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                best = n - 1 - i;
                break;
            }
        }

        // the fixed-leftmost to the rightmost
        for (int i = n - 1; i >= 0; i--) {
            if (colors[0] != colors[i]) {
                best = Math.max(i, best);
                break;
            }
        }

        return best;
    }

}
