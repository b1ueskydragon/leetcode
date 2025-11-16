package leetcode.p1513;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumSubTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "0110111, 9",
            "101, 2",
            "111111, 21",
            "10111111011011011101101110110111011011110110111011011101101110110111011011101101110, 119",
            "0, 0",
            "1, 1"
    })
    void testNumSub(String s, int expected) {
        assertThat(underTest.numSub(s)).isEqualTo(expected);
    }

}
