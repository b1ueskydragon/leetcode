package leetcode.p0985;

// fast and low memory usage
class Solution {
    // nums and queries may not have same lengths
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // even numbers' sum at the current point
        // to avoid computing even sums every time from nums (since it's O(N^2))
        int evenSum = 0;

        // initial even numbers' sum
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        final int[] res = new int[queries.length];
        int i = 0; // index of res

        for (int[] query : queries) {
            final int index = query[1];
            final int acc = query[0];

            final int prevVal = nums[index];
            nums[index] += acc;
            final int currVal = nums[index];

            if (prevVal % 2 == 0) {
                evenSum -= prevVal;
            }

            if (currVal % 2 == 0) {
                evenSum += currVal;
            }
            res[i++] = evenSum;
        }

        return res;
    }
}
