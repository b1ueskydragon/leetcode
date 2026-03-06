package leetcode.p1784;

class Solution {

    static class V1 {

        // Constraint: s starts with '1'.
        public boolean checkOnesSegment(String s) {
            int i = 0;
            final int n = s.length();
            // The first segment.
            while (i < n && s.charAt(i) == '1') {
                i++;
            }
            // Check if there is another segment.
            // If exists, i cannot reach to the end index.
            while (i < n && s.charAt(i) == '0') {
                i++;
            }
            return i == n;
        }

    }

    static class V2 {

        // Constraint: s starts with '1'.
        public boolean checkOnesSegment(String s) {
            char prev = '1';
            for (int i = 1; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (prev == '0' && curr == '1') {
                    return false;
                }
                prev = curr;
            }
            return true;
        }

    }

}
