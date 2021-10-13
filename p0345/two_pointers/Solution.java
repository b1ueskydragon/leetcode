package leetcode.p0345.two_pointers;

import java.util.Set;

class Solution {
  private final static Set<Character> vowels =
      Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  private static boolean isVowel(char c) {
    return vowels.contains(c);
  }

  private static void swap(char[] xs, int l, int r) {
    char tmp = xs[l];
    xs[l] = xs[r];
    xs[r] = tmp;
  }

  // s consist of printable ASCII characters.
  public String reverseVowels(String s) {
    final char[] xs = s.toCharArray();
    int l = 0, r = xs.length - 1;

    while (l <= r) {
      while (l <= r && !isVowel(xs[l])) l++;
      while (l <= r && !isVowel(xs[r])) r--;
      if (l <= r && isVowel(xs[l]) && isVowel(xs[r])) swap(xs, l++, r--);
    }

    return String.valueOf(xs);
  }
}
