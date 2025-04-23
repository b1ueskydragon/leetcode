package leetcode.p1399.s2025;

class Solution {
    public int countLargestGroup(int n) {
        // Constraints: 1 <= n <= 10^4
        // Max digit sum should be 9 + 9 + 9 + 9 = 36
        final int[] freq = new int[37];
        freq[0] = -1; // unused slot
        for (int num = 1; num <= n; num++) {
            freq[digitSum(num)]++;
        }

        int maxFreq = -1;
        for (int f : freq) {
            maxFreq = Math.max(f, maxFreq);
        }

        int cnt = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                cnt++;
            }
        }

        return cnt;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
