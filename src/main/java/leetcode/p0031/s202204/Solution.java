package leetcode.p0031.s202204;

class Solution {
    //      . . .
    // [5,2,4,3,1]
    //    . . .
    // [5,2,1,3,4]
    //
    // [5,3,1,2,4]
    //
    public void nextPermutation(int[] nums) {
        final int N = nums.length;
        if (N < 2) return;

        // 1st step reverse
        // reverse range:= [右->左 方向で increment が続く要素の index, 末尾 index]
        final int last = N - 1;
        final int i = findLastIncrementIndex(nums, last);

        // [1,2,3]
        if (i == last) swap(nums, i - 1, i);
        else reverse(nums, i, last);

        // [3,2,1] -> [1,2,3]
        if (i == 0) return;

        // 2nd step swap, if needed.
        // target := i の一つ左 index and 次のそれより大きい要素の index
        final int head = i - 1;
        final int j = findFirstIncrementIndex(nums, N, head, i);

        // Second reverse is not needed.
        if (j == N) return;

        swap(nums, head, j);
    }

    private static int findLastIncrementIndex(int[] nums, int last) {
        while (last > 0 &&
                nums[last - 1] >= nums[last]) last--;
        return last;
    }

    private static int findFirstIncrementIndex(int[] nums, final int limit, final int head, int start) {
        while (start < limit &&
                nums[head] >= nums[start]) start++;
        return start;
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l <= r) swap(nums, l++, r--);
    }

    private static void swap(int[] nums, final int i, final int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
