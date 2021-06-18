package leetcode.p0067.patternalize;

class Solution {
  // All patterns of a[i] + b[j] + carry and its original sum
  // 0 + 0 + 0  base 0 carry 0 (sum 0)
  // 0 + 0 + 1  base 1 carry 0 (sum 1)
  // 0 + 1 + 0  base 1 carry 0 (sum 1)
  // 0 + 1 + 1  base 0 carry 1 (sum 2)
  // 1 + 0 + 0  base 1 carry 0 (sum 1)
  // 1 + 0 + 1  base 0 carry 1 (sum 2)
  // 1 + 1 + 0  base 0 carry 1 (sum 2)
  // 1 + 1 + 1  base 1 carry 1 (sum 3)
  public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    final StringBuilder sb = new StringBuilder();
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int base = carry; // accumulate previous carry first
      if (i >= 0) {
        base += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        base += b.charAt(j--) - '0';
      }

      // previous carry was already accumulated
      // hence accumulate prev carry again is unnecessary
      carry = base / 2;

      base %= 2;

      sb.append(base);
    }

    // flush
    if (carry > 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }
}
