package leetcode.p1578;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        // Keep the maximum one among the section (consecutive elements)
        int sumAll = 0;
        for (int num : neededTime) {
            sumAll += num;
        }
        int l = 0;
        int r = 1;
        int sumOfTheMax = 0;
        for (; r < colors.length(); r++) {
            if (colors.charAt(l) == colors.charAt(r)) {
                continue;
            }
            int sectionMax = 0;
            // section: [l, r)
            for (int i = l; i < r; i++) {
                sectionMax = Math.max(sectionMax, neededTime[i]);
            }
            sumOfTheMax += sectionMax;
            // Prepare to the next section
            l = r;
        }

        // The last section
        int sectionMax = 0;
        for (int i = l; i < r; i++) {
            sectionMax = Math.max(sectionMax, neededTime[i]);
        }
        sumOfTheMax += sectionMax;
        return sumAll - sumOfTheMax;
    }
}
