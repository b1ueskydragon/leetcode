package leetcode.p1518.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumWaterBottlesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "9, 3, 13",
            "15, 4, 19",
            "100, 11, 109",
            "1, 100, 1",
            "99, 2, 197",
            "100, 2, 199",
            "100, 100, 101",
            "11, 100, 11"
    })
    void numWaterBottles(int numBottles, int numExchange, int expected) {
        assertThat(underTest.numWaterBottles(numBottles, numExchange)).isEqualTo(expected);
    }

}
