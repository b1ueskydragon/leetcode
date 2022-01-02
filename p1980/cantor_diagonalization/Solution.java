package leetcode.p1980.cantor_diagonalization;

class Solution {
  // n unique binary strings each of length n
  // Cantor's diagonal argument
  public String findDifferentBinaryString(String[] nums) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      sb.append((char) (nums[i].charAt(i) ^ 1));
    }
    return sb.toString();
  }
}
