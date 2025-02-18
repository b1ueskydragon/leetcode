package leetcode.p2375;

/**
 * Runtime 1 ms (75.25%)
 * Memory 42.08 MB (18.52%)
 */
class Solution {
  public String smallestNumber(String pattern) {
    final int n = pattern.length();
    // 要するに buffer
    final int[] backwardDs = countBackwardD(pattern);

    int[] xs = new int[n + 1]; // result
    int i = 0;
    xs[i] = 1; // start point
    if (pattern.startsWith("D")) {
      // S D I D
      // 1 _ 1 _
      // 2 1 (本当は 3 + d buffer の 1 = 4)4 3
      xs[i] += backwardDs[0];
    }

    int soFarI = xs[i]; // backup the latest I-positioned number

    while (i < n) {
      final char curr = pattern.charAt(i);
      if (curr == 'I') {
        // 次が D である I の場合,「本来入れようとした数字 + さらに次の I が出るまでの D の個数分」の数字を入れる
        xs[i + 1] = soFarI + 1 + backwardDs[i + 1]; // ds の方は番兵を飛ばすための + 1
//        if (pattern.charAt(i + 1) == 'D') {
//          xs[i + 1] = soFarI + 1 + backwardDs[i + 1]; // ds の方は番兵を飛ばすための + 1
//        } else {
//          xs[i + 1] = xs[i] + 1;
//        }
        soFarI = xs[i + 1]; // 本来入れようとした数字が「次の I」の場合に備えて
      } else {
        xs[i + 1] = xs[i] - 1;
      }
      i++;
    }
    return joinAsString(xs);
  }

  int[] countBackwardD(String pattern) {
    // 先頭が D の場合のための番兵
    pattern = "I" + pattern;
    final int n = pattern.length();
    final int[] ds = new int[n];
    int cnt = 0;
    // 「次が D の I」の時しか参照しないので他の slot は埋めなくて OK
    // S I I I D I D D D
    // _ _ _ 1 _ 3 _ _ _  (I が出るまでのD)
    // S D D D
    // 3 _ _ _
    // S D I D
    // 1 _ 1 _
    for (int i = n - 1; i >= 0; i--) {
      if (pattern.charAt(i) == 'D') {
        cnt++;
      }
      // 「左から数ええ I が出るまでの D」を求めているので適宜リセット
      if (pattern.charAt(i) == 'I') {
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
