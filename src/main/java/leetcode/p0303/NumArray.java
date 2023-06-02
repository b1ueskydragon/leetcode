package leetcode.p0303;

class NumArray {

  private int[] sumCache;

  public NumArray(int[] nums) {
    this.sumCache = new int[nums.length + 1];
    int i = 0;
    for (int num : nums) {
      sumCache[++i] = sumCache[i - 1] + num;
    }
  }

  // There are many calls to sumRange function
  public int sumRange(int i, int j) {
    return sumCache[j + 1] - sumCache[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
