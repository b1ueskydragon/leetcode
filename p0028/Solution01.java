package leetcode.p0028;

/*
 * If a substring (k length) is posed in a string,
 * it should be,
 *
 *          [           ]         -- subStr
 *         j1.......    jk
 *         /          /
 * [      [          ]          ] -- Str
 *     j1 + i.....  jk + i
 */
class Solution01 {
  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) { // i is an index of an Str.
      for (int j = i; ; j++) { // j is an index of a subStr.

        if (needle.charAt(j) != haystack.charAt(j + i)) break; // go to the next i
      }
    }
  }
}
