package leetcode.p0788;

class Solution {
    // valid digits: 0,1,2,5,6,8,9
    private static final int[] RULES = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int n) {
        final boolean[] marked = new boolean[n + 1];
        for (int num = 1; num <= n; num++) {
            if (marked[num]) {
                continue;
            }
            final int unw = rotate(num);
            if (unw == -1) {
                continue;
            }
            marked[num] = true;
            if (unw <= n) {
                marked[unw] = true;
            }
        }
        int count = 0;
        for (boolean t : marked) {
            if (t) {
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
