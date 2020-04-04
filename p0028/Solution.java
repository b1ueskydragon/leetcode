package leetcode.p0028;

class Solution {
    public int strStr(String haystack, String needle) {
        int fromIndex = 0;
        // haystack = len N
        // needle = len K

        // find a start point of haystack where starts with needle's head char
        // retrieve k, k <= O(K)
        // if not found, skip k + head

        // bbb bbbbbbbbab
        // bab
        // + K
        // bbb bbb bbbbbab
        //     bab
        // + K
        // bbbbbb bbb bbab
        //        bab
        // + K
        // bbbbbbbbb bba b
        //           bab
        // + 1
        // bbbbbbbbbb bab
        //            bab
        return -1;
    }
}
