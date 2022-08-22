package leetcode.p1338.sort.bucket;

class Solution {
    // 2 <= arr.length <= 10^5
    // 1 <= arr[i] <= 10^5
    public int minSetSize(int[] arr) {
        final int max = 100000;
        final int[] frequencies = new int[max + 1];

        int threshold = arr.length / 2;

        for (int v : arr) {
            frequencies[v]++;
            if (frequencies[v] >= threshold) {
                // early return
                return 1;
            }
        }

        // a bucket which guarantees order of "frequencies"
        final int[] bucket = new int[max + 1];
        for (int freq : frequencies) {
            if (freq == 0) {
                continue;
            }
            bucket[freq]++;
        }

        int res = 0;
        for (int freq = max; freq >= 0; freq--) {
            // frequency of "frequencies"
            final int freqCount = bucket[freq];
            if (freq * freqCount >= threshold) {
                // Math.ceil(threshold / freq)
                final int minCount = threshold / freq + ((threshold % freq > 0) ? 1 : 0);
                return res + minCount;
            }
            threshold -= freq * freqCount;
            res += freqCount;
            if (threshold <= 0) {
                return res;
            }
        }
        return res;
    }
}
