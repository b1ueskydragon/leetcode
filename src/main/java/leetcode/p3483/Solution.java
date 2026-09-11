package leetcode.p3483;

class Solution {
    // Unique 3-Digit Even Numbers
    public int totalNumbers(int[] digits) {
        backtrack(digits, 0, 0);
        int count = 0;
        for (boolean m : matched) {
            if (m) {
                count++;
            }
        }
        return count;
    }

    // indices. digits.length <= 10
    final boolean[] seen = new boolean[10];
    // values. every value is less than 1000
    final boolean[] matched = new boolean[1000];

    private void backtrack(
            int[] digits,
            int trial,
            int acc
    ) {
        if (trial == 3) {
            // Only evaluate when the trial is 3.
            if (acc >= 100 && acc < 1000 && acc % 2 == 0) {
                matched[acc] = true;
            }
            return;
        }
        // Permutation.
        // backward (自分より左の自分と異なる index) も改めて探索・append 必要ありなので i=0.
        // Restart from index 0 at each depth because digit order matters (unused index to the left).
        // e.g., 134 != 341
        for (int i = 0; i < digits.length; i++) {
            if (seen[i]) {
                // Ensure using the current index only once.
                continue;
            }
            // pick
            seen[i] = true;
            backtrack(digits, trial + 1, acc * 10 + digits[i]);
            // after backtrack, put it back. parameters are reset.
            seen[i] = false;
        }
    }
}
