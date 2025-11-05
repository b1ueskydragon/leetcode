package leetcode.p3318;

class Solution {
    private static final int LIMIT = 51;

    public int[] findXSum(int[] nums, int k, int x) {
        final int n = nums.length;
        final int[] freq = new int[LIMIT];

        final int[] res = new int[n - k + 1];
        int j = 0;

        int l = 0;
        int r = k - 1;
        while (l <= r) {
            freq[nums[l]]++;
            l++;
        }

        while (r < n) {
            res[j++] = computeSectionSum(freq, k, x);

            // Prepare to the next window
            int prevL = r - k + 1;
            freq[nums[prevL]]--;
            r++;
            if (r < n) {
                freq[nums[r]]++;
            }
        }

        return res;
    }

    private static int computeSectionSum(final int[] freq, final int k, final int x) {
        int sectionSum = 0;
        int count = x;
        // The max possible frequency of k-length subarray is k
        for (int f = k; f >= 0; f--) {
            // Tied: Larger number is prioritized
            for (int v = LIMIT - 1; v >= 0; v--) {
                // If found, accumulate it
                if (freq[v] == f) {
                    sectionSum += v * f;
                    count--;
                }
                if (count == 0) {
                    return sectionSum;
                }
            }
        }
        return sectionSum;
    }
}
