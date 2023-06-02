package leetcode.p0022.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<String> generateParenthesis(int n) {
    final List<String> result = new ArrayList<>();

    // as like as timeline of generating each valid parentheses.
    final Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair("", 0, 0));

    while (!queue.isEmpty()) {
      final Pair head = queue.poll();
      if (head.getOpen() == n && head.getClose() == n) {
        result.add(head.getAcc());
      }

      // always open first
      if (head.getOpen() < n) {
        queue.offer(new Pair(head.getAcc() + "(", head.getOpen() + 1, head.getClose()));
      }
      // close if open is enough
      if (head.getClose() < head.getOpen()) {
        queue.offer(new Pair(head.getAcc() + ")", head.getOpen(), head.getClose() + 1));
      }
    }

    return result;
  }

  static class Pair {
    private String acc;
    private int open;
    private int close;

    Pair(String acc, int open, int close) {
      this.acc = acc;
      this.open = open;
      this.close = close;
    }

    String getAcc() {
      return this.acc;
    }

    int getOpen() {
      return this.open;
    }

    int getClose() {
      return this.close;
    }

  }
}
