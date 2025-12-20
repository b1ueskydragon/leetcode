package leetcode.p0944;

class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c0 = '0'; // lower than 'a'
            for (int j = 0; j < strs.length; j++) {
                char c1 = strs[j].charAt(i);
                if (c0 > c1) {
                    count++;
                    break;
                }
                c0 = c1;
            }
        }
        return count;
    }
}
