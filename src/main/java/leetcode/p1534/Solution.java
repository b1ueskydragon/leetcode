package leetcode.p1534;

class Solution {
    // Constraint
    // - 0 <= i < j < k < arr.length
    // - 0 <= arr[i] <= 1000 (We can use a brute force)
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        final int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
