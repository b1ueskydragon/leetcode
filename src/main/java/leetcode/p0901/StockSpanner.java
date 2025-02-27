package leetcode.p0901;

import java.util.ArrayDeque;

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {

    // at most 10000 calls will be made to #next
    private final int[] backUp;

    // current day
    private int i;

    // current より大きい数字の index を保持する
    // top -> bottom の順で大きくなる
    private final ArrayDeque<Integer> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        backUp = new int[10001];
        i = 0;
    }

    // 要は配列の中で右から左に数えて price より「次に大きい数字」が出るまでの距離
    // 距離は index の差分で出したい
    public int next(int price) {
        backUp[i] = price;
        while (!stack.isEmpty() && backUp[stack.peek()] <= price) {
            stack.pop();
        }

        // current より小さい値の index は全て pop した後
        // current の左に current より大きい値がもうない時も current 自身から左端まで数えないといけないので -1
        int j = (stack.isEmpty()) ? -1 : stack.peek();
        stack.push(i);
        return i++ - j;
    }
}
