package leetcode.p0921.stack;

import java.util.Stack;

class Solution {
  public int minAddToMakeValid(String S) {
    final char open = '(';
    final char close = ')';
    final Stack<Character> opens = new Stack<>();

    int add = 0;
    for (char c : S.toCharArray()) {
      if (c == open) {
        opens.push(c);
        continue;
      }
      if (!opens.isEmpty()) {
        opens.pop();
        continue;
      }
      add++;
    }
    return add + opens.size();
  }
}
