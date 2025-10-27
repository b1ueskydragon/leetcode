package leetcode.p2125;

class Solution {
    public int numberOfBeams(String[] bank) {
        int validPrevCount = 0;
        int count = 0;
        int ans = 0;
        for (String row : bank) {
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    count++;
                }
            }
            if (validPrevCount > 0) {
                ans += validPrevCount * count;
            }
            // If current count is 0, skip the current one and takeover the valid (>0) previous one
            validPrevCount = (count == 0) ? validPrevCount : count;
            // Reset the status
            count = 0;
        }
        return ans;
    }
}
