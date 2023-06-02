package leetcode.p0682.array;

class Solution {
    public int calPoints(String[] ops) {
        final int N = ops.length;
        final int[] mem = new int[N];
        // A current position on mem
        // This must work independently of the index which manipulates ops
        int pos = 0;
        int acc = 0; // To reduce an operation of sum all
        for (String v : ops) {
            switch (v) {
                case "D": // It is guaranteed there will always be a previous score
                    mem[pos] = mem[pos - 1] * 2;
                    acc += mem[pos];
                    pos++;
                    continue;
                case "C": // It is guaranteed there will always be a previous score
                    pos--;
                    acc -= mem[pos];
                    mem[pos] = 0;
                    continue;
                case "+": // It is guaranteed there will always be two previous scores
                    mem[pos] = mem[pos - 2] + mem[pos - 1];
                    acc += mem[pos];
                    pos++;
                    continue;
                default: // This wil be a numeric value
                    mem[pos] = Integer.parseInt(v);
                    acc += mem[pos];
                    pos++;
            }
        }
        return acc;
    }
}
