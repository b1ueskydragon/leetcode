package leetcode.p1647;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    // s contains only lowercase English letters (at most 26)
    // 要するに最大 26 種類の unique な数字になるべき
    // 増やすことはできない, 減らすのはできる
    public int minDeletions(String s) {
        final int[] freqMap = new int[26]; // a to z
        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }
        Arrays.sort(freqMap);
        Set<Integer> exists = new HashSet<>();
        int gap = 0;
        // sorted 基準, as-is 後方の zero 続きは無視, 例えば
        // as-is [4, 4, 4, 4, 3, 3, 2, 2, 1, 1] なら
        // to-be [4, 3, 2, 1, 0, 0, 0, 0, 0, 0],
        // as-is [6, 4, 4, 2] なら
        // to-be [6, 4, 3, 2]
        // つまり accumulate each gaps
        for (int i = 25; i >= 0; i--) {
            int currFreq = freqMap[i];
            while (exists.contains(currFreq)) {
                if (currFreq == 0) {
                    break;
                }
                freqMap[i]--;
                currFreq = freqMap[i]; // 更新
                gap++;
            }
            exists.add(currFreq); // anyway, 更新
        }
        return gap;
    }
}
