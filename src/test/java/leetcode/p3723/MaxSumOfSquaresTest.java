package leetcode.p3723;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSumOfSquaresTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "100, 500, 9999999999999999999999999999999999999999999999999999999500000000000000000000000000000000000000000000",
            "1, 9, 9",
            "200000, 2000000, ''"
    })
    void testMaxSumOfSquares(int num, int sum, String maxScoreStr) {
        assertThat(underTest.maxSumOfSquares(num, sum)).isEqualTo(maxScoreStr);
    }
}
