package leetcode.p0788;

class Solution {
    // valid digits: 0,1,2,5,6,8,9
    private static final int[] RULES = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int n) {
        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (rotate(num) != -1) {
                count++;
            }
        }
        return count;
    }

    private int rotate(int num) {
        int k = 1;
        int acc = 0;
        final int ori = num;
        while (num > 0) {
            final int d = RULES[num % 10];
            if (d == -1) {
                return -1;
            }
            acc += k * d;
            k *= 10;
            num /= 10;
        }
        return acc == ori ? -1 : acc;
    }
}
