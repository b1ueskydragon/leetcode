package leetcode.p0028;

import java.util.Arrays;

class Solution {

    private static int[] skipTable(String subStr) {
        final int K = subStr.length();
        // ba_________
        // bab
        // [matched count:skippable count]
        // [0:1, 1:1, 2:2]
        // ->     b  ba
        //    [1, 1, 2]
        final int[] table = new int[K];
        table[0] = 1; // the case of different from the first char.
        int i = 0, j = 0;
        while (i < K && j < K) {
            // [b] a b
            // [b] a b
            if (subStr.charAt(i) == subStr.charAt(j)) {
                table[j] = i + 1;
                i++;
                //  b [a] b
                // [b] a  b
            } else {
                //   b [a] b
                //  [b] a  b
                table[j] = 1; // normally skip (+1);
                j++;
            }
        }
        return table;
    }

    public int strStr(String haystack, String needle) {
        Arrays.stream(skipTable(needle)).forEach(System.out::println);
//        int i = 0;
//        while (i < haystack.length()) {
//        }
        return -1;
    }
}
