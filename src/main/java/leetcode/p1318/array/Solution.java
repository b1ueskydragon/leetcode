package leetcode.p1318.array;

// Beats 100%, O(N) Execution time
// Using additional O(N) space
class Solution {
    // constraints: max is 10^9 (max 30 digits in binary)
    private static final int N = 30;

    // a | b should be c
    public int minFlips(int a, int b, int c) {
        final int[] binaryA = toBinary(a);
        final int[] binaryB = toBinary(b);
        final int[] binaryC = toBinary(c);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            final int toBe = binaryC[i];
            if ((binaryA[i] | binaryB[i]) == toBe) {
                continue;
            }
            // pattern 1: either one `1` can make `1`
            if (toBe == 1) {
                cnt++;
                continue;
            }
            // pattern 2: only both `0` can make `0`
            if ((binaryA[i] & binaryB[i]) == 1) {
                cnt += 2;
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    private static int[] toBinary(int x) {
        final int[] binary = new int[N];
        int i = N - 1;
        while (x > 0) {
            binary[i] = x % 2;
            x /= 2;
            i--;
        }
        return binary;
    }
}
