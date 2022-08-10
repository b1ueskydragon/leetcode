package leetcode.p1720;

class Solution {
    // A XOR B == B XOR A
    public int[] decode(int[] encoded, int first) {
        final int n = encoded.length;
        final int[] arr = new int[n + 1];
        arr[0] = first;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}
