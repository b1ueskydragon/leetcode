package leetcode.p0997.directedGraph;

class Solution {
  // Directed Graph. judge is the end point of whole points and it's the point which cannot proceed anymore.
  public int findJudge(int N, int[][] trust) {
    final int[] votes = new int[N + 1]; // votes per each person. index 0 is a sentinel.

    for (int[] pair : trust) {
      votes[pair[0]] = -1; // cannot be a candidate.
      votes[pair[1]]++; // maybe candidate.
    }

    for (int i = 1; i <= N; i++) {
      if (votes[i] == N - 1) return i; // judge should get N-1 votes (judge cannot vote itself).
    }

    return -1;
  }
}
