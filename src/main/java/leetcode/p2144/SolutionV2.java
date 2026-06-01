package leetcode.p2144;

class SolutionV2 implements Solution {
    public int minimumCost(int[] cost) {
        // e,g,
        // 2, 2, 5, 6, 7, 9
        // max(cost)=9 はタダでもらえない, 払うしかない.
        final int limit = 100;
        final int[] freq = new int[limit + 1];
        for (int num : cost) {
            freq[num]++;
        }
        // e.g.,
        // 1, / 2, 3, 4, / 5, 7, 8, / 8, 9, 9, / 9, 9, 9
        // 1, / 2, 3, 4, / 5, 7, 8, / 8, 8, 9, / 9, 9, 9
        // 1, / 2, 3, 4, / 5, 7, 7, / 7, 8, 9, / 9, 9, 9
        int sum = 0;
        int carry = 0;
        int prevNum = 0;
        for (int num = limit; num >= 1; num--) {
            final int count = freq[num];
            if (count == 0) {
                continue;
            }
            // 前回余った部分を, その次の計算で合算する.
            sum += prevNum * carry;
            int enoughSections = (count + carry) / 3;
            if (carry == 2) {
                // 前回の余った部分で section ごと埋めているので, 1 section 消す.
                enoughSections -= 1;
            }
            sum += num * 2 * enoughSections;
            if (carry == 1) {
                // 前回の余った部分で一つ埋められているので, 1つ消す.
                sum -= num;
            }
            carry = (count + carry) % 3;
            prevNum = num;
        }
        return sum + (carry * prevNum);
    }
}
