package leetcode.p0034;

class Solution {

    // O(log N) time complexity, non-decreasing order ... Binary search

    static class V1 {

        public int[] searchRange(int[] nums, int target) {
            final int n = nums.length;
            int left = 0;
            int right = n - 1;

            int first = findFirstPos(nums, left, right, target);
            int last = findLastPos(nums, left, right, target);

            return new int[]{first, last};
        }

        private static int findFirstPos(int[] nums, int left, int right, int target) {
            if (left > right) {
                return -1;
            }
            final int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                return findFirstPos(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                return findFirstPos(nums, left, mid - 1, target);
            } else {
                // nums[mid] == target
                // Try to explore left further
                int cand = findFirstPos(nums, left, mid - 1, target);
                // Once a valid `cand` is found, it will be returned up the call stack
                return (cand == -1) ? mid : cand;
            }
        }

        private static int findLastPos(int[] nums, int left, int right, int target) {
            if (left > right) {
                return -1;
            }
            final int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                return findLastPos(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                return findLastPos(nums, left, mid - 1, target);
            } else {
                // nums[mid] == target
                // Try to explore right further
                int cand = findLastPos(nums, mid + 1, right, target);
                // Once a valid `cand` is found, it will be returned up the call stack
                return (cand == -1) ? mid : cand;
            }
        }

    }

    static class V2 {

        public int[] searchRange(int[] nums, int target) {
            final int n = nums.length;
            int first = findFirstPos(nums, target, 0, n - 1);
            int last = findLastPos(nums, target, 0, n - 1);
            return new int[]{first, last};
        }

        private int findFirstPos(int[] nums, int target, int left, int right) {
            int soFar = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // Keep track of the earliest index where target is found so far
                    soFar = mid;
                    // `target` was found but still need to scan left side
                    right = mid - 1;
                }
            }
            return soFar;
        }

        private int findLastPos(int[] nums, int target, int left, int right) {
            int soFar = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // Keep track of the latest index where target is found so far
                    soFar = mid;
                    // `target` was found but still need to scan right side
                    left = mid + 1;
                }
            }
            return soFar;
        }

    }

}
