package leetcode.p0029;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DivideTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "10, 3, 3",
            "-2147483648, -2, 1073741824",
            "2147483647, 2147483647, 1",
            "1, 2147483647, 0"
    })
    void testDivide(int dividend, int divisor, int expected) {
        assertThat(underTest.divide(dividend, divisor)).isEqualTo(expected);
    }

}
