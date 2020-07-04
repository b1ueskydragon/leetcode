package leetcode.p0322;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int minCount = Integer.MAX_VALUE;
    int[] memo = new int[amount + 1];
    minCount = dfs(memo, minCount, coins, amount);
    // System.out.print("[");
    // for (int x: memo) {
    //     System.out.printf("%d , ", x);
    // }
    // System.out.print("]\n");
    return minCount < 0 ? -1 : minCount;
  }

  private int dfs(int[] memo, int minCount, int[] coins, int amount) {
    if (amount == 0) { // base case.
      return 0;
    }
    for (int coin : coins) {
      if (amount < coin) continue;
      minCount = Math.min(dfs(memo, minCount, coins, amount - coin) + 1, minCount);
      memo[amount] = minCount;
    }
    return minCount;
  }
}
