package leetcode.p2144;

import java.util.Arrays;

class SolutionV1 implements Solution {
    public int minimumCost(int[] cost) {
        // 2,2,5,6,7,9
        // e,g, max(cost)=9 はタダでもらえない, 払うしかない.
        Arrays.sort(cost);
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i = i - 3) {
            if (i == 0) {
                sum += cost[i];
            } else {
                sum += (cost[i] + cost[i - 1]);
            }
        }
        return sum;
    }
}
