package leetcode.p0134.greedy;

class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    final int n = gas.length; // same as cost.length
    int start = 0;
    int tankAll = 0; // The total amount of remaining gas after driving the circular route
    int tank = 0; // The amount of remaining gas from the start point
    for (int i = 0; i < n; i++) {
      // No matter which point will be a feasible start point,
      // all gas will be accumulated eventually, so become a negative at some point is OK.
      tankAll += gas[i] - cost[i];
      // A current tank decides whether the start point is feasible or not (Whether it is able to departure to the next or not).
      tank += gas[i] - cost[i];
      if (tank < 0) {
        // Cannot depart even we've got a gas from the current station,
        // since the cost is too large or accumulated gas is too few.
        // Reset the start point and the gas accumulation from the start point.
        start = i + 1;
        tank = 0;
      }
    }
    return (tankAll >= 0) ? start : -1;
  }
}
