package leetcode.p0215.s202308.quicksort;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums[n - k];
    }

    // in-place
    // start and end are both inclusive
    // both are fixed position in each partition
    private static void quickSort(int[] nums, final int start, final int end) {
        int l = start;
        int r = end;
        final int pivot = start + (end - start) / 2;

        // initial pivot value should be fixed
        // since pivot position also could be swapped
        final int center = nums[pivot];

        while (l <= r) {
            while (nums[l] < center) l++;
            while (nums[r] > center) r--;

            if (l <= r) {
                swap(nums, l, r);
                // move cursors after swapped
                l++;
                r--;
            }
        }

        // divide after cursors are completely crossed
        // partition and sort only when necessary
        // specifically, when each cursor (l, r) is at the same position as any fixed position (start, end)
        // an additional divide-and-conquer is unnecessary
        if (start < r) {
            quickSort(nums, start, r);
        }
        if (l < end) {
            quickSort(nums, l, end);
        }
    }

    private static void swap(int[] nums, final int l, final int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
