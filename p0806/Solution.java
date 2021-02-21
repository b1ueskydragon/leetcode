package leetcode.p0806;

// Starting at the beginning of s, write as many letters on the first line such that the total width does not exceed 100 pixels.
// widths.length == 26, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
// s only contains lowercases.
class Solution {
  public int[] numberOfLines(int[] widths, String s) {
    int lines = 1;
    // per line
    int pixels = 0;
    for (char c : s.toCharArray()) {
      final int w = widths[c % 97];
      if (pixels + w <= 100) {
        pixels += w;
        continue;
      }
      lines++;
      pixels = w;
    }

    // total number of lines, the width of the last line in pixels
    return new int[]{lines, pixels};
  }
}
