package leetcode.p2379;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        final int n = blocks.length();
        int minModifiable = n; // the worst (maximum) case: all slots are filled with consecutive W

        int wSlot = 0;

        // The initial try to build the initial window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                wSlot++;
            }
            // we don't need to count black
            // since the size k window considers all slots are filled with consecutive B
        }
        minModifiable = Math.min(minModifiable, wSlot);

        int l = 1;
        int r = k;

        while (r < n) {
            // if needed, trim the head
            wSlot = (blocks.charAt(l - 1) == 'W') ? wSlot - 1 : wSlot;
            // if needed, append the last
            wSlot = (blocks.charAt(r) == 'W') ? wSlot + 1 : wSlot;
            minModifiable = Math.min(minModifiable, wSlot);

            // slide to the next window
            l++;
            r++;
        }

        return minModifiable;
    }
}
