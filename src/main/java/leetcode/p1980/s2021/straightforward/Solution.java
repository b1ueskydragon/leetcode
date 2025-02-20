package leetcode.p1980.s2021.straightforward;

class Solution {
  public String findDifferentBinaryString(String[] nums) {
    // nums containing n unique binary strings, n == nums.length
    final int n = nums.length;
    final boolean[] dict = new boolean[1 << n];
    for (String str : nums) {
      dict[Integer.parseInt(str, 2)] = true;
    }
    for (int i = 0; i < dict.length; i++) {
      if (!dict[i]) return String.valueOf(String.format("%0" + n + "d", Integer.valueOf(Integer.toBinaryString(i))));
    }
    return "";
  }
}
