package leetcode.p0739;

import java.util.Stack;

// Stack's pop
// 1.「不要なデータを捨てる」ための pop
// -「次に条件を満たす要素を効率的に見つける」パターン
// - e.g. 次の小さい(or 大きい)値を見つける
// 2.「探索経路を戻る」ための pop
// - binary tree, 経路探索
class SolutionV2 {
    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final int[] res = new int[n];
        // stack indices, not a value
        // 距離は基本的に index の差分で求める
        final Stack<Integer> stack = new Stack<>();

        // 「次に大きい値」は左から右へと見ていくので
        // 最初トライした再帰ロジック同様に「後ろにある大きい値」を見つける考え方は同様
        for (int i = n - 1; i >= 0; i--) {
            // pop until we find next greater element to the right
            // current より後ろにある大きな値が溜まっていく
            // つまり,
            // current 基準, current より高い値のみが stack に常に存在し,
            // stack の top (pop すると出てくる部分) がその中で最も低い気温で順に積もれる
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                // stack 内の, 現在の値より小さい値は不要なので pop
                stack.pop();
            }
            // 目的のもの（ちょうど次の大きい値）を見つけたとき
            if (!stack.isEmpty()) {
                // at this point「この温度が後の処理でも必要かもしれない」
                // so just peek, do not pop from here
                res[i] = stack.peek() - i;
            }
            // put current (current value's index) to the stack
            // なぜなら後の値から見てこの current が「次に大きい値」になる可能性がある
            // だから一応入れる (後の current さんが不要だと思えば pop してくれる)
            stack.push(i);
        }
        return res;
    }
}
