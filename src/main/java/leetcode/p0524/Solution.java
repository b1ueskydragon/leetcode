package leetcode.p0524;

import java.util.List;

class Solution {
  /**
   * TODO improve or another
   *
   * Note;
   * ++ (post increment) is faster than += (assign)
   * e. g.) 40ms -> 24ms
   *
   * @param entire find from
   * @param x      target to find
   * @return true if x is sub-sequence of entire
   */
  private boolean isSubSeq(String entire, String x) {
    int i = 0, j = 0;
    while (i < entire.length() && j < x.length()) {
      if (entire.charAt(i) == x.charAt(j)) j++;
      i++;
    }
    return j == x.length();
  }

  public String findLongestWord(String s, List<String> d) {
    var longestWord = "";
    for (String word : d) {
      if (isSubSeq(s, word)) {
        if (longestWord.length() < word.length() ||
            longestWord.length() == word.length() &&
                word.compareTo(longestWord) < 0) longestWord = word;
      }
    }
    return longestWord;
  }

}
