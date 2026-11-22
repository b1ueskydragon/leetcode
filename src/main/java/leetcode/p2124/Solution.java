package leetcode.p2124;

class Solution {
    public boolean checkString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int bit = s.charAt(i) - 'a';
            // Sum already exists, but it has not updated after new bit accumulated.
            if (sum > 0 && sum + bit == sum) {
                return false;
            }
            sum += bit;

        }
        return true;
    }
}
