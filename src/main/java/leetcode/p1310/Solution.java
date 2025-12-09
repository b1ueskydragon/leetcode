package leetcode.p1310;

class Solution {
    // XOR properties:
    // x^x = 0
    // x^0 = x
    // x^y = y^x (commutativity)
    // (x^y)^z = x^(y^z) (associativity)
    // e.g.,
    // a^b^c = d,
    // d^a = a^b^c^a = a^a^b^c = 0^b^c = b^c
    public int[] xorQueries(int[] arr, int[][] queries) {
        final int n = arr.length;
        final int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        final int m = queries.length;
        final int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            final int[] q = queries[i];
            answer[i] = (q[0] == 0) ? prefixXor[q[1]] : prefixXor[q[1]] ^ prefixXor[q[0] - 1];
        }
        return answer;
    }
}
