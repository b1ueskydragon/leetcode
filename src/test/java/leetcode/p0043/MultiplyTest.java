package leetcode.p0043;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456, 56088",
            "999, 99, 98901",
            "99999, 999999999, 99998999900001",
            "99999999, 0, 0",
            "0, 0, 0"
    })
    void testMultiply(String num1, String num2, String expected) {
        assertThat(underTest.multiply(num1, num2)).isEqualTo(expected);
    }
}
