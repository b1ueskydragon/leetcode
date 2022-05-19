package leetcode.p0495;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int end = 0, acc = 0;
        for (int t : timeSeries) {
            acc += duration;
            if (t <= end) acc += t - end;
            end = t + duration;
        }
        return acc;
    }
}
