package leetcode.p1338.sort.bucket;

class Solution {
    // 2 <= arr.length <= 10^5
    // 1 <= arr[i] <= 10^5
    public int minSetSize(int[] arr) {
        final int max = 100000;
        final int[] freq = new int[max + 1];

        // threshold
        int t = arr.length / 2;

        for (int v : arr) {
            freq[v]++;
            if (freq[v] >= t) {
                // early return
                return 1;
            }
        }

        // a bucket which gurantees order of "frequencies"
        final int[] bucket = new int[max + 1];
        for (int c : freq) {
            if (c == 0) {
                continue;
            }
            bucket[c]++;
        }

        int res = 0;
        for (int i = max; i >= 0; i--) {
            // frequency of "frequencies"
            final int freqFreq = bucket[i];
            if (i * freqFreq >= t) {
                // Math.ceil(t / i)
                final int minCount = t / i + ((t % i > 0) ? 1 : 0);
                return res + minCount;
            }
            t -= i * freqFreq;
            res += freqFreq;
            if (t <= 0) {
                return res;
            }
        }
        return res;
    }
}
