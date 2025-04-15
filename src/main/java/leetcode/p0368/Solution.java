package leetcode.p0368;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // To ensure we only consider one direction (from smaller to larger)
        Arrays.sort(nums);

        final int n = nums.length;
        // Store the longest subset size upto `i`
        final int[] maxSize = new int[n];
        // Keep track of the previous index in the subset chain
        final int[] prevPos = new int[n];
        for (int i = 0; i < n; i++) {
            maxSize[i] = 1;
            // Constraint: `nums` are positive integers
            // -1 represents there is no previous chain (i is the start point)
            prevPos[i] = -1;
        }

        // Build a chain
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) {
                    continue;
                }
                // Update the `maxSize` only if the new size is larger than current
                if (maxSize[j] + 1 > maxSize[i]) {
                    maxSize[i] = maxSize[j] + 1;
                    prevPos[i] = j;
                }
            }
        }

        // Path reconstruction (Traceback the chain from the last position)
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            maxI = (maxSize[maxI] < maxSize[i]) ? i : maxI;
        }
        final int targetFixedSize = maxSize[maxI];
        final LinkedList<Integer> maxChain = new LinkedList<>();

        int i = maxI;
        while (maxChain.size() < targetFixedSize) {
            maxChain.addFirst(nums[i]);
            i = prevPos[i];
        }

        return maxChain;
    }
}
