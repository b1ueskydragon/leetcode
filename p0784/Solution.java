package leetcode.p0784;

import java.util.ArrayList;
import java.util.List;

/** backtracking */
public class Solution {
  private static void permutation(String S, char[] chunk, int pos, List<String> res) {
    if (pos == S.length()) { // pos to on the end
      res.add(String.valueOf(chunk));
      return;
    }
    char curr = S.charAt(pos);
    chunk[pos] = curr;
    permutation(S, chunk, pos + 1, res);

    if (curr >= 97 && curr <= 122) { // lower cases
      chunk[pos] = (char) (curr - 32); // replace in-place to upper
      permutation(S, chunk, pos + 1, res);
    }
    if (curr >= 65 && curr <= 90) { // upper cases
      chunk[pos] = (char) (curr + 32); // replace in-place to lower
      permutation(S, chunk, pos + 1, res);
    }
  }

  public List<String> letterCasePermutation(String S) {
    List<String> res = new ArrayList<>();
    permutation(S, new char[S.length()], 0, res);
    return res;
  }
}
