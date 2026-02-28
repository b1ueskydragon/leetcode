package leetcode.p1404;

class Solution {
    public int numSteps(String s) {
        // The index of LSB.
        int r = s.length() - 1;
        int carry = 0;
        int count = 0;
        while (r > 0) {
            // e.g.,
            // 10011 -> 10100 -> 1010 -> 101 -> 110 -> 11 -> 100 -> 10 -> 1
            // 1000 -> 100 -> 10 -> 1
            // We only need to keep LSB and the current carry.
            int lsb = s.charAt(r) - '0';
            int carriedLsb = lsb + carry;
            if (carriedLsb % 2 == 1) {
                carry = (carriedLsb + 1) > 1 ? 1 : 0;
                // +1 のあと必ず current LSB は 0 になるので, ついでに捨てる.
                // +1, >> 1 で 2 operations.
                count += 2;
                r--;
            } else {
                // Right shift once, logically.
                count++;
                r--;
            }
        }
        // carry: 0, lsb: 1 -> count
        // carry: 1, lsb: 1 -> Process "10", count + 1;
        return count + carry;
    }
}
