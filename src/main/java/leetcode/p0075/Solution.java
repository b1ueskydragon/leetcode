package leetcode.p0075;

class Solution {

    static class V2 {
        // nums ⊃ {0, 1, 2}
        public void sortColors(int[] nums) {
            final int n = nums.length;
            int low = 0; // An end point of 0 (exclusive)
            int mid = 0; // A current cursor
            int high = n - 1; // A start point of 2 (inclusive)

            while (mid <= high) {
                if (nums[mid] == 1) {
                    // low は決まっていると想定して動く
                    mid++;
                    continue;
                }
                if (nums[mid] == 0) {
                    swap(nums, low, mid);
                    // low は常に 0 の終点 (exclusive) になる必要がある
                    low++;
                    // mid は常に low 以上を走る必要がある
                    mid++;
                } else { // nums[mid] == 2
                    swap(nums, mid, high);
                    // high は常に 2 の始点 (inclusive) になる必要がある
                    high--;
                    // swap 後, 新たな nums[mid] (元 nums[high]) がまだわからないので mid 進めない
                }
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    static class V1 {
        public void sortColors(int[] nums) {
            final int[] freq = new int[3];
            for (int num : nums) {
                freq[num]++;
            }
            int i = 0;
            for (int num = 0; num < 3; num++) {
                for (int j = 0; j < freq[num]; j++) {
                    nums[i++] = num;
                }
            }
        }

    }
}
