package leetcode.p1122.array;

class Solution {
    // Ordering of items in arr1 are the same as in arr2.
    // The elements of arr2 are distinct.
    // All elements in arr2 are also in arr1.
    // 0 <= arr1[i], arr2[i] <= 1000
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // nums to index, count to value
        // this guarantees sorted in ascending order
        final int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }

        // this will be used in the next loop
        int step = 0;

        for (int num : arr2) {
            final int dup = count[num];
            count[num] = 0;
            for (int i = 0; i < dup; i++) {
                arr1[i + step] = num;
            }
            step += dup;
        }

        for (int num = 0; num < count.length; num++) {
            // this nums are only exist in arr1
            final int dup = count[num];
            for (int i = 0; i < dup; i++) {
                arr1[i + step] = num;
            }
            step += dup;
        }

        return arr1;
    }
}
