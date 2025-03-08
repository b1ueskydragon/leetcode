package leetcode.p2379;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        final int n = blocks.length();
        int minModifiable = n; // the worst (maximum) case: all slots are filled with consecutive W

        int shouldFill = 0;
        int tailCache = -1; // previous wCnt from the previous window

        // The initial try
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                shouldFill++;
            }
            // we don't need to count black
            // since the size k window considers all slots are filled with consecutive B
        }
        // to pass the next window, remove the head
        tailCache = (blocks.charAt(0) == 'W') ? shouldFill - 1 : shouldFill;
        minModifiable = Math.min(minModifiable, shouldFill);

        int l = 1;
        int r = l + k - 1;

        while (r < n) {
            shouldFill = (blocks.charAt(r) == 'W') ? tailCache + 1 : tailCache;
            minModifiable = Math.min(minModifiable, shouldFill);
            tailCache = (blocks.charAt(l) == 'W') ? shouldFill - 1 : shouldFill;

            // slide to the next window
            l++;
            r++;
        }

        return minModifiable;
    }
}
