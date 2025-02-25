package leetcode.p1647;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinDeletionsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "aab, 0",
            "aaabbbcc, 2",
            "ceabaacb, 2",
            "abc, 2",
            "bbbcccddeee, 5",
            "aaaabbbbccccddddeeefffgghhij, 18",
            // ソート済み基準, 必ずしも frequency が -1 ずつ降順しない case
            "accdcdadddbaadbc, 1",
            "abcdefghijklmnopqrstuvwxwz, 23"
    })
    void testMinDeletions(String s, int minDeletion) {
        assertThat(underTest.minDeletions(s)).isEqualTo(minDeletion);
    }
}
