package leetcode.p0242.array;

class Solution {
    public boolean isAnagram(String s, String t) {
        final int n = s.length();
        if (n != t.length()) return false;

        final int[] countMap = new int[26];
        int i = -1;
        while (++i < n) {
            countMap[s.charAt(i) - 97]++;
            countMap[t.charAt(i) - 97]--;
        }
        for (int cnt : countMap) {
            if (cnt != 0) return false;
        }

        return true;
    }
}
