package leetcode.p2833;

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        // Only two horizontal moving, +1, -1.
        // And, for example, "L_RL__R" の総移動量は, same as "LLRR___".
        int sum = 0;
        int offset = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L' -> sum -= 1;
                case 'R' -> sum += 1;
                case '_' -> offset++;
            }
        }
        return (sum < 0) ? Math.abs(sum - offset) : sum + offset;
    }
}
