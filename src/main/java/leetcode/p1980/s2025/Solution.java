package leetcode.p1980.s2025;

import java.util.HashSet;
import java.util.Set;

/**
 * Runtime 3 ms (36.03%), Memory 41.35 MB (87.34%)
 */
public class Solution {
    // max 16-bit
    // n == nums.length
    // 1 <= n <= 16
    // nums[i].length == n
    // nums[i] is either '0' or '1'
    // All the strings of nums are unique
    public String findDifferentBinaryString(String[] nums) {
        final int n = nums[0].length();
        int maxExcluded = 1 << n;
        final Set<Integer> set = convertToSet(nums);
        for (int i = 0; i < maxExcluded; i++) {
            if (!set.contains(i)) {
                return convertToBinaryStr(i, n);
            }
        }
        return "";
    }

    private Set<Integer> convertToSet(String[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (String str : nums) {
            set.add(convertToNumber(str));
        }
        return set;
    }

    private int convertToNumber(String binaryStr) {
        int n = binaryStr.length();
        int res = 0;
        int level = 0;
        for (int i = n - 1; i >= 0; i--) {
            // (int) '0' == 48
            // '0' - 48 = 0
            // '1' - 48 = 1
            int bit = binaryStr.charAt(i) - '0';
            res += (bit * (1 << level));
            level++;
        }
        return res;
    }

    private String convertToBinaryStr(int num, int level) {
        final int len = level;
        int res = 0;
        int stage = 1;
        while (level > 0) {
            res += ((num % 2) * stage);
            num /= 2;
            stage *= 10;
            level--;
        }
        String resStr = String.valueOf(res);
        final int padding = len - resStr.length();
        for (int i = 0; i < padding; i++) {
            resStr = "0" + resStr;
        }
        return resStr;
    }
}
