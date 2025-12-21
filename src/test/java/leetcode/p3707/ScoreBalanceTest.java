package leetcode.p3707;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBalanceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "cabcdfi, false",
            "abcbd, true",
            "abcbda, false",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaz, true",
            "baaaaaaaaaaaaaaaaaaaaaaaaz, true"
    })
    void testScoreBalance(String s, boolean canSplit) {
        assertThat(underTest.scoreBalance(s)).isEqualTo(canSplit);
    }

}
