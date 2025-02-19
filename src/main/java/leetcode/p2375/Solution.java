package leetcode.p2375;

/**
 * Runtime 1 ms (75.25%)
 * Memory 42.08 MB (18.52%)
 */
class Solution {
  public String smallestNumber(String pattern) {
    final int n = pattern.length();
    // buffer (offset)
    final int[] offset = countBackwardD(pattern);

    final int[] xs = new int[n + 1]; // result
    int i = 0;
    xs[i] = 1; // start point
    if (pattern.startsWith("D")) {
      // e.g.
      // ('S' is a sentinel, this represents the start point)
      // S D I D
      // 1 _ 1 _
      // 2 1 4 3
      //   ( ↑ 4 = original number 3 + buffer 1 )
      xs[i] += offset[0];
    }

    int soFarI = xs[i]; // backup the latest I-positioned number

    while (i < n) {
      final char curr = pattern.charAt(i);
      if (curr == 'I') {
        // 次が 'D' である 'I' の場合,「本来入れようとした数字 + さらに次の 'I' が出るまでの 'D' の個数分」の数字を入れる
        // 次が 'D' ではない 'I' の場合は offset = 0 になるのでこのままで大丈夫
        xs[i + 1] = soFarI + 1 + offset[i + 1]; // about backwardDs, to skip sentinel, we need + 1
        soFarI = xs[i + 1]; // 本来入れようとした数字が「次の I」の場合に備えて
      } else {
        xs[i + 1] = xs[i] - 1;
      }
      i++;
    }
    return joinAsString(xs);
  }

  int[] countBackwardD(String pattern) {
    // sentinel for the pattern starts with 'D'
    pattern = "I" + pattern;
    final int n = pattern.length();
    final int[] ds = new int[n];
    int cnt = 0;
    // offset は「次が 'D' の 'I'」の時しか使わないので他の slot は埋めず 0 のままで OK
    // e.g.
    // ( '_' represents 0 value)
    // S I I I D I D D D
    // _ _ _ 1 _ 3 _ _ _  (I が出るまでのD)
    // S D D D
    // 3 _ _ _
    // S D I D
    // 1 _ 1 _
    for (int i = n - 1; i >= 0; i--) {
      final char curr = pattern.charAt(i);
      if (curr == 'D') {
        cnt++;
      }
      // 「左から数えて 'I' が出るまでの 'D'」を求めているので 'I' を見つけたらカウンターリセット
      else {
        ds[i] = cnt;
        cnt = 0;
      }
    }
    return ds;
  }

  private String joinAsString(int[] xs) {
    final var sb = new StringBuilder();
    for (int x : xs) {
      sb.append(x);
    }
    return sb.toString();
  }
}
