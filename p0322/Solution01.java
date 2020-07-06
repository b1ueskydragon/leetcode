package leetcode.p0322;

class Solution01 {
  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    return currStageCount(memo, coins, amount);
  }

  private int currStageCount(int[] memo, int[] coins, int amount) {
    if (amount == 0) { // base case.
      return 0;
    }
    if (memo[amount] != 0) {
      return memo[amount];
    }
    int finalMinCount = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (amount < coin) continue;
      finalMinCount = Math.min(finalMinCount, currStageCount(memo, coins, amount - coin));
    }
    memo[amount] = (finalMinCount == Integer.MAX_VALUE) ? -1 : finalMinCount + 1;
    return memo[amount];
  }
}
