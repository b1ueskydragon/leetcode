package leetcode.p0628;

class Solution2026 {
    // 3 <= nums.length <= 10^4
    // -1000 <= nums[i] <= 1000
    public int maximumProduct(int[] nums) {
        // Candidates:
        // ans >= 0
        // maxpos1 x maxpos2 x maxpos3
        // maxpos1 x minneg1 x minneg2
        // ans < 0
        // maxpos1 x maxpos2 x minneg1 (there are only two positives)
        // maxneg1 x maxneg2 x maxneg3 (no positives at all)
        // Note:
        // maxpos = 1 is the biggest.
        // maxneg = a small absolute value. 1 is the biggest.
        // minneg = a big absolute value. 1 is the smallest.

        int maxpos1 = Integer.MIN_VALUE;
        int maxpos2 = Integer.MIN_VALUE;
        int maxpos3 = Integer.MIN_VALUE;

        int maxneg1 = Integer.MIN_VALUE;
        int maxneg2 = Integer.MIN_VALUE;
        int maxneg3 = Integer.MIN_VALUE;

        int minneg1 = Integer.MAX_VALUE;
        int minneg2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= 0) {
                if (num > maxpos3) {
                    maxpos3 = num;
                    if (maxpos3 > maxpos2) {
                        int tmp = maxpos3;
                        maxpos3 = maxpos2;
                        maxpos2 = tmp;
                    }
                    if (maxpos2 > maxpos1) {
                        int tmp = maxpos2;
                        maxpos2 = maxpos1;
                        maxpos1 = tmp;
                    }
                }
            } else {
                if (num > maxneg3) {
                    maxneg3 = num;
                    if (maxneg3 > maxneg2) {
                        int tmp = maxneg2;
                        maxneg2 = maxneg3;
                        maxneg3 = tmp;
                    }
                    if (maxneg2 > maxneg1) {
                        int tmp = maxneg1;
                        maxneg1 = maxneg2;
                        maxneg2 = tmp;
                    }
                }

                if (num < minneg2) {
                    minneg2 = num;
                    if (minneg2 < minneg1) {
                        int tmp = minneg1;
                        minneg1 = minneg2;
                        minneg2 = tmp;
                    }
                }
            }
        }

        int posCand1 = Integer.MIN_VALUE;
        if (isValid(maxpos1) && isValid(maxpos2) && isValid(maxpos3)) {
            posCand1 = maxpos1 * maxpos2 * maxpos3;
        }
        int posCand2 = Integer.MIN_VALUE;
        if (isValid(maxpos1) && isValid(minneg1) && isValid(minneg2)) {
            posCand2 = maxpos1 * minneg1 * minneg2;
        }
        int negCand1 = Integer.MIN_VALUE;
        if (isValid(maxpos1) && isValid(maxpos2) && isValid(minneg1)) {
            negCand1 = maxpos1 * maxpos2 * minneg1;
        }
        int negCand2 = Integer.MIN_VALUE;
        if (isValid(maxneg1) && isValid(maxneg2) && isValid(maxneg3)) {
            negCand2 = maxneg1 * maxneg2 * maxneg3;
        }

        return Math.max(Math.max(posCand1, posCand2), Math.max(negCand1, negCand2));
    }

    private boolean isValid(int x) {
        return x != Integer.MIN_VALUE && x != Integer.MAX_VALUE;
    }
}
