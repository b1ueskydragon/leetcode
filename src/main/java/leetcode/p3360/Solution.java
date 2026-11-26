package leetcode.p3360;

class Solution {
    public boolean canAliceWin(int n) {
        // odd left = alice wins, even left = bob wins.
        int w = 10;
        while (n >= w) {
            n -= w--;
        }
        return (w & 1) == 1;
    }
}
