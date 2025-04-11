package leetcode.p2843;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            if (isSymmetric(num)) {
                count++;
            }
        }
        return count;
    }

    // Constraint: 1 <= num <= 10000
    private int getLimit(int num) {
        if (num < 10) {
            return 1;
        }
        if (num < 100) {
            return 2;
        }
        if (num < 1000) {
            return 3;
        }
        return 4;
    }

    // Constraint: Numbers with an odd number of digits are never symmetric
    private boolean isSymmetric(int num) {
        final int limit = getLimit(num);
        if (limit % 2 != 0) {
            return false;
        }
        int acc = 0;
        int count = 0;
        int half = limit / 2;
        while (num > 0) {
            if (count < half) {
                acc += num % 10;
            } else {
                acc -= num % 10;
            }
            num /= 10;
            count++;
        }
        return acc == 0;
    }
}
