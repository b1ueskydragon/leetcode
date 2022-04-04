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
        if (nums.length < 2) return;

        // 1st step reverse
        // reverse range:= [右->左 方向で increment が続く要素の index, 末尾 index]
        int last = nums.length - 1;
        int i = last;
        while (nums[i - 1] >= nums[i]) {
            i--;
            if (i == 0) {
                // [3,2,1]
                reverse(nums, 0, last);
                return;
            }
        }

        if (i == last) {
            // [1,2,3]
            reverse(nums, i - 1, i);
        } else {
            reverse(nums, i, last);
        }


        // 2nd step swap, if needed.
        // target := i の一つ左 index and 次のそれより大きい要素の index
        int head = i - 1;
        while (nums[head] >= nums[i]) {
            i++;
            if (i == nums.length) {
                // Second reverse is not needed.
                return;
            }
        }

        swap(nums, head, i);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l <= r) swap(nums, l++, r--);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
