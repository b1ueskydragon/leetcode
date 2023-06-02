package leetcode.p0168;

class Solution {
  // 26-ary number without 0
  public String convertToTitle(int columnNumber) {
    final StringBuilder sb = new StringBuilder();

    int carry = 0; // from previous remaining
    while (columnNumber > 0) {
      int base = columnNumber % 26;
      if (base == 0) {
        base = 26;
        carry = -1;
      }
      sb.append((char) (base + 64));
      columnNumber /= 26;
      columnNumber += carry;
      carry = 0;
    }

    return sb.reverse().toString();
  }
}
