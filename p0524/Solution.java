package leetcode.p0524;

import com.google.common.annotations.VisibleForTesting;

import java.util.List;

public class Solution {
  /**
   * @param entire find from
   * @param x      target to find
   * @return true if x is sub-sequence of entire
   */
  @VisibleForTesting
  boolean isSubSeq(String entire, String x) { // TODO improve or another
    int i = 0, j = 0;
    while (i < entire.length() && j < x.length()) {
      if (entire.charAt(i) == x.charAt(j)) j += 1;
      i += 1;
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
