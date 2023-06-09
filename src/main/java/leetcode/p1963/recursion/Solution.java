package leetcode.p1963.recursion;

class Solution {
    public int minSwaps(String s) {
        // track the number of opening.
        int opening = 0;
        for (int i = 0; i < s.length(); i++) {
            // open a bracket pair first.
            if (s.charAt(i) == '[') opening++;
                // erase opening if closing follows and opening has a enough accumulation.
            else if (opening > 0) opening--;
        }
        return count(opening, 0);
    }

    // opening 1 => 1
    // opening 2 => 1
    // opening 3 => 1 + opening 1 ( e.g. ]]][[[ is equal to [] ][ [] )
    // opening 4 => 1 + opening 2 ( e.g. ]]]][[[[ is equal to [] ]][[ [] )
    private static int count(int opening, int base) {
        if (opening == 0) return base;
        if (opening <= 2) return base + 1;
        return count(opening - 2, 1 + base);
    }
}
