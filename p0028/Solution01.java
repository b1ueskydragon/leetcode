package leetcode.p0028;

/*
 * If a substring (k length) is posed in a string,
 * it should be,
 *
 *          [           ]         -- subStr
 *          1.......   j
 *         /          /
 * [      [          ]          ] -- originalStr
 *       1+i......  j+i
 *
 *  O(k * N), N is the length of originalStr.
 */
class Solution01 {
  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) { // i is an index of an originalStr.
      for (int j = 0; ; j++) { // j is an index of a subStr. we should retrieve subStr from 0 for each i.
        if (j == needle.length()) return i; // we found. just return a buffer index.
        if (i + j == haystack.length()) return -1; // overflowed from originalStr
        if (needle.charAt(j) != haystack.charAt(j + i)) break; // go to the next i
      }
    }
  }
}
