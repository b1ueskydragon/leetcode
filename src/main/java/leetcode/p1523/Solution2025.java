package leetcode.p1523;

class Solution2025 implements Solution {

    public int countOdds(int low, int high) {
        // when [odd_1, odd_2],
        // odd count := (odd_2 - odd_1) / 2 + 1

        // e.g.,
        // Those have exactly same odd count:
        // 2, 3, 5, 7, 8
        //    3, 5 ,7, 8
        // 2, 3, 5 ,7
        //    3, 5, 7

        // Normalize both low and high to odd
        return (((high % 2 == 0) ? (high - 1) : high) - ((low % 2 == 0) ? (low + 1) : low)) / 2 + 1;
    }

}
