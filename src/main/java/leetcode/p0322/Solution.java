package leetcode.p0322;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int minCount = Integer.MAX_VALUE;
    minCount = dfs(minCount, coins, amount);
    return minCount < 0 ? -1 : minCount;
  }

  private int dfs(int minCount, int[] coins, int amount) {
    if (amount == 0) { // base case.
      return 0;
    }
    for (int coin : coins) {
      if (amount < coin) continue;
      minCount = Math.min(dfs(minCount, coins, amount - coin) + 1, minCount);
    }
    return minCount;
  }
}
