package leetcode.p2078;

class SolutionV1 implements Solution {

    public int maxDistance(int[] colors) {
        // number -> {first occurrence, last occurrence}
        final int[][] occurrences = new int[101][2];
        for (int i = 0; i < 101; i++) {
            occurrences[i][0] = -1;
            occurrences[i][1] = -1;
        }
        for (int i = 0; i < colors.length; i++) {
            if (occurrences[colors[i]][0] == -1) {
                occurrences[colors[i]][0] = i;
            }
            occurrences[colors[i]][1] = i;
        }

        int best = 0;
        for (int i = 0; i < occurrences.length - 1; i++) {
            if (occurrences[i][0] == -1) {
                continue;
            }
            int l1 = occurrences[i][0];
            int r1 = occurrences[i][1];
            for (int j = i + 1; j < occurrences.length; j++) {
                if (occurrences[j][0] == -1) {
                    continue;
                }
                int l2 = occurrences[j][0];
                int r2 = occurrences[j][1];
                best = Math.max(best, Math.max(Math.abs(r2 - l1), Math.abs(r1 - l2)));
            }
        }

        return best;
    }

}
