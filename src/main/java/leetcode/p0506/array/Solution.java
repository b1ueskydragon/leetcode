package leetcode.p0506.array;

class Solution {
  public String[] findRelativeRanks(int[] score) {
    int max = 0; // 0 <= score[i]
    for (int scr : score) {
      max = Math.max(scr, max);
    }

    // value is the position (index) of i (each score)
    // dict[0] is a sentinel
    final int[] dict = new int[max + 1];
    for (int i = 0; i < score.length; i++) {
      dict[score[i]] = i + 1; // index + 1 to distinguish with nothing, 0
    }

    int rank = 1;
    final String[] res = new String[score.length];
    for (int i = max; i >= 0; i--) {
      if (dict[i] == 0) {
        // not in the score
        continue;
      }
      final int scr = dict[i] - 1;
      res[scr] = getRank(rank);
      rank++;
    }

    return res;
  }

  private static String getRank(int rank) {
    switch (rank) {
      case 1:
        return "Gold Medal";
      case 2:
        return "Silver Medal";
      case 3:
        return "Bronze Medal";
      default:
        return String.valueOf(rank);
    }
  }
}
