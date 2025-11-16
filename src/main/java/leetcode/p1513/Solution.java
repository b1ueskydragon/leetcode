package leetcode.p1513;

class Solution {

    private static final int M = 1000_000_007;

    public int numSub(String s) {
        long sum = 0;
        final int n = s.length();
        for (int l = 0; l < n; l++) {
            if (s.charAt(l) == '1') {
                int r = l + 1;
                while (r < n && s.charAt(r) == '1') {
                    r++;
                }
                // A current range of the `1`s substring: [l, r)
                // Use long type to prevent the excess at the subsequent processing
                final long subLen = r - l;

                // Note: Since substring is contiguous, combination is not feasible
                // Instead, simply countable:
                // e.g.,
                // 111111 (len 6)
                // `1` -> 6 patterns
                // `11` -> 5 patterns
                // `111` -> 4 patterns
                // `1111` -> 3 patterns
                // `11111` -> 2 patterns
                // `111111` -> 1 patterns
                final long acc = (1 + subLen) * subLen / 2;

                // Mod it every time before sum to the previous sum,
                // to prevent the excess; Mod is applicable to each sum
                sum = (sum + acc) % M;

                l = r;
            }

        }
        return (int) sum;
    }
}
