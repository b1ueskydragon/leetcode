package leetcode.p0067.string;

class Solution {
  public String addBinary(String a, String b) {
    final int aLen = a.length(), bLen = b.length();
    final int maxLen = Math.max(aLen, bLen);
    final int[] bins = new int[maxLen + 1];

    for (int i = maxLen - 1; i >= 0; i--) {
      final int x = getCurrentDigit(a, aLen, maxLen, i);
      final int y = getCurrentDigit(b, bLen, maxLen, i);

      final int base;
      if (x + y > 1) {
        base = 0;
        bins[i] = 1;
      } else {
        base = x + y;
      }

      if (bins[i + 1] + base > 1) {
        bins[i] = 1;
        bins[i + 1] = 0;
      } else {
        bins[i + 1] += base;
      }
    }

    final StringBuilder sb = new StringBuilder();
    int i = (bins[0] == 0) ? 1 : 0;
    for (; i <= maxLen; i++) {
      sb.append(bins[i]);
    }

    final String res = sb.toString();
    return (res.equals("")) ? "0" : res;
  }

  private int getCurrentDigit(final String s,
                              final int len,
                              final int maxLen,
                              final int i) {
    if (maxLen > len) {
      final int index = i - (maxLen - len);
      return (index < 0) ? 0 : Character.getNumericValue(s.charAt(index));
    }
    return Character.getNumericValue(s.charAt(i));
  }

}
