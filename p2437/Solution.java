package leetcode.p2437;

class Solution {
    public int countTime(String time) {
        int possibilities = 1;
        // time is a validated string
        final String[] hhmm = time.split(":");
        final String hh = hhmm[0];
        final String mm = hhmm[1];
        final char a = hh.charAt(0);
        final char b = hh.charAt(1);
        final char c = mm.charAt(0);
        final char d = mm.charAt(1);
        // hh
        if (a == '?') {
            if (b == '?') {
                possibilities *= 24;
            } else if (Character.getNumericValue(b) > 3) {
                possibilities *= 2;
            } else {
                possibilities *= 3;
            }
        } else if (Character.getNumericValue(a) < 2) {
            if (b == '?') {
                possibilities *= 10;
            }
            // if b is number, possibilities *= 1
        } else { // a is 2
            if (b == '?') {
                possibilities *= 4;
            }
            // if b is number, possibilities *= 1
        }
        // mm
        if (c == '?') {
            if (d == '?') {
                possibilities *= 60;
            } else {
                possibilities *= 6;
            }
        } else {
            if (d == '?') {
                possibilities *= 10;
            }
            // if d is number, possibilities *= 1
        }
        return possibilities;
    }
}
