package leetcode.p2515;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        final int n = words.length;

        int bestForward = -1;
        int bestBackward = -1;

        // 1週だけする.
        // Won't exceed n, but as a safety measure, pass i % n always.
        for (int i = 0; i < n; i++) {
            int p1 = (startIndex + i) % n;
            if (bestForward == -1 && words[p1].equals(target)) {
                bestForward = i % n;
            }
            int p2 = ((startIndex - (i % n)) + n) % n;
            if (bestBackward == -1 && words[p2].equals(target)) {
                bestBackward = i % n;
            }
        }

        return Math.min(bestForward, bestBackward);
    }
}
