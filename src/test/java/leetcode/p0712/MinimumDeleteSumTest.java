package leetcode.p0712;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDeleteSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "delete, leet, 403",
            "sea, eat, 231",
            "sseeeeeeeaaaasseeeeteeee, seeeeeettttttt, 2338",

            // 異なる一文字ずつの場合, 最終的にはどちらも削除する必要がある.
            // 先に空文字との比較 (base case) をしてから dp 埋めに入る理由がわかりやすい.
            // 必ず通る終端状態を先に確定する.
            // "" vs "e"
            // "t" vs ""
            "t, e, 217",

            // s2 が t になるためには, 最後の e を必ず消す必要がある.
            // 実は, 後方の suffix ""(s1) vs "e"(s2) における削除判断は, "t"(s1) vs "t"(s2) の時点ではすでに完結 (dp[1][1]) している.
            // そのため "t"(s1) vs "t"(s2) は先決した状態を引き継ぐのみ.
            // dp[0][0] ← dp[0 + 1][0 + 1]
            "t, te, 101"
    })
    void testMinimumDeleteSum(String s1, String s2, int minSum) {
        assertThat(underTest.minimumDeleteSum(s1, s2)).isEqualTo(minSum);
    }
}
