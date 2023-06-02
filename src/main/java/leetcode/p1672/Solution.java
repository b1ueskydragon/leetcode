package leetcode.p1672;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] xs : accounts) max = Math.max(max, sum(xs));
        return max;
    }

    private static int sum(int[] xs) {
        int sum = 0;
        for (int x : xs) sum += x;
        return sum;
    }
}
