package leetcode.p0495;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0;
        int end = 0;
        int acc = 0;
        for (int t : timeSeries) {
            if (t <= end) {
                acc += t + duration - end;
                end = t + duration;
            } else {
                start = t;
                end = t + duration;
                acc += end - start;
            }
        }
        return acc;
    }
}
