package leetcode.p0868.s2025;

class Solution {
    public int binaryGap(int n) {
        return countDistance(convertToBinaryStr(n));
    }

    private int countDistance(String binaryStr) {
        int start = 0;
        final int n = binaryStr.length();
        for (int i = 0; i < n; i++) {
            char curr = binaryStr.charAt(i);
            if (curr == '1') {
                start = i;
                break;
            }
        }

        int maxDistance = 0;
        int end = 0;
        // the distance of 1001 is 3 (3-0)
        // the distance of 11 is 1 (1-0)
        for (int i = start; i < n; i++) {
            char curr = binaryStr.charAt(i);
            if (curr == '1') {
                end = i;
                maxDistance = Math.max(maxDistance, end - start);
                start = end;
            }
        }
        return maxDistance;
    }

    private String convertToBinaryStr(int n) {
        StringBuilder acc = new StringBuilder();
        while (n > 0) {
            int bit = n % 2;
            acc.append(bit); // 元は acc = bit + acc だけど, 遅いので StringBuilder + reverse
            n >>= 1; // equivalent to n /= 2
        }
        return acc.reverse().toString();
    }
}
