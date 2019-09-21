package leetcode.p0524;

import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.List;

public class Solution01 {

  private static int[][] dic;

  // side-effect
  private static void init(String s) {
    dic = new int[s.length() + 1][26]; // has sentinel
    for (int[] xs : dic) {
      Arrays.fill(xs, -1);
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      dic[i] = Arrays.copyOf(dic[i + 1], 26); // carrying up previous index
      dic[i][s.charAt(i) - 'a'] = i;
    }
  }

  // test init
  // TODO make a spec
  public static void main(String[] args) {
    init("abc"); // another; "aaa"
    for (int[] x : dic) {
      for (int y : x) {
        System.out.printf("%s, ", y);
      }
      System.out.println();
    }
  }

  @VisibleForTesting
  boolean isSubSeq(String word) {
    int pos = 0;
    for (int i = 0; i < word.length(); i++) {
      int index = dic[pos][word.charAt(i) - 'a'];
      if (index == -1) return false;
      pos = index + 1;
    }
    return true;
  }

  public String findLongestWord(String s, List<String> d) {
    init(s);
    var longestWord = "";
    for (String word : d) {
      if (isSubSeq(word)) {
        if (longestWord.length() < word.length() ||
            longestWord.length() == word.length() &&
                word.compareTo(longestWord) < 0) longestWord = word;
      }
    }
    return longestWord;
  }
}
