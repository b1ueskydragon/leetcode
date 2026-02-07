package leetcode.p1653;

class Solution {
    public int minimumDeletions(String s) {
        final int n = s.length();

        // curr を見ている時点では
        // ここまでの合算が正しい (aa..abb..b と揃っている) 前提で
        // prev だけ見る
        // さらに prev は見ない
        // next も見ない

        // 左 -> 右 走査, aa..abb..b 制約,
        // 状態の境界 (選択の制約変わる分岐) : 境界より left: a, 境界より right: b.
        // まだ a Zone にいるときの最小 cost (つまり b を消す).
        final int[] dpZoneA = new int[n];
        // b Zone を考慮した最小 cost (左 chunk aa..a は出来上がった前提で bb..b を完成する).
        final int[] dpZoneB = new int[n];

        dpZoneA[0] = s.charAt(0) == 'a' ? 0 : 1;
        // dpZoneB[0] = 0; // Since a single character is already balanced.

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'b') {
                // 単純に current b を消す.
                dpZoneA[i] = dpZoneA[i - 1] + 1;
                // Nothing to do. Just take over the previous result.
                dpZoneB[i] = dpZoneB[i - 1];
            } else {
                // Nothing to do. Just take over the previous result.
                dpZoneA[i] = dpZoneA[i - 1];
                // これまでの b を消す (dpZoneA から引いて来れる) VS current a を消す.
                dpZoneB[i] = Math.min(dpZoneA[i], dpZoneB[i - 1] + 1);
            }
        }

        return dpZoneB[n - 1];
    }
}
