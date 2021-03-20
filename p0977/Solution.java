package leetcode.p0977;

class Solution {
  public int[] sortedSquares(int[] nums) {
    final int N = nums.length;
    final int[] squares = new int[N];

    if (nums[N - 1] < 0) {
      for (int i = N - 1; i >= 0; i--) {
        final int x = nums[i];
        squares[N - 1 - i] = x * x;
      }
      return squares;
    }

    int i = -1;
    while (nums[++i] < 0) ;

    // nums[r] >= 0
    int r = i;
    // nums[l] < 0
    int l = i - 1;

    // squares index
    int j = 0;
    while (r < N && l >= 0) {
      int pos = nums[r];
      int neg = nums[l];
      if (pos > -1 * neg) {
        squares[j] = neg * neg;
        l--;
      } else {
        squares[j] = pos * pos;
        r++;
      }
      j++;
    }

    // flush
    while (l >= 0) {
      final int x = nums[l--];
      squares[j++] = x * x;
    }
    while (r < N) {
      final int x = nums[r++];
      squares[j++] = x * x;
    }

    return squares;
  }
}
