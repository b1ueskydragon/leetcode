package leetcode.p0347.bucketSort;

import java.util.ArrayList;

// O(N * k) time and space (not sure). N is a length of the array, k is a max duplicated frequencies.
class Solution {
    // may return the answer in any order
    // it is guaranteed that the answer is unique (but duplicate frequencies may exist).
    public int[] topKFrequent(int[] nums, int k) {
        // num -> frequency
        // -10^4 <= nums[i] <= 10^4
        final int[] numCount = new int[20001];
        final int offset = 10000;
        for (int num : nums) {
            numCount[num + offset]++;
        }

        // sort frequencies (bucket sort)
        // duplicate frequencies may exist, so using List type instead of int
        // frequency -> num(s)
        // 1 <= nums.length <= 10^5
        final ArrayList<Integer>[] frequencies = new ArrayList[100001];
        for (int num = 0; num < numCount.length; num++) {
            final int count = numCount[num];
            if (frequencies[count] == null) {
                frequencies[count] = new ArrayList<>();
            }
            frequencies[count].add(num);
        }

        final int[] res = new int[k];
        int i = 0, limit = k;
        for (int count = frequencies.length - 1; count >= 1; count--) {
            if (frequencies[count] == null) {
                continue;
            }
            for (int num : frequencies[count]) {
                res[i++] = num - offset;
                limit--;
            }
            if (limit == 0) {
                return res;
            }
        }
        return res;
    }
}
