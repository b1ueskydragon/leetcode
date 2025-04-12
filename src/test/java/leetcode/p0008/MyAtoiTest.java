package leetcode.p0008;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MyAtoiTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            " -042, -42",
            "3.14159, 3",
            "+-12, 0",
            "-999999999999999999999999999999, -2147483648",
            "999999999999999999999999999999, 2147483647",
            "00000-42a1234, 0",
            "-9 8 7, -9",
            "9 8 7, 9",
            "0 8 7, 0",
            "- 12, 0",
            " + 12, 0",
            "2147483646, 2147483646"
    })
    void testMyAtoi(String s, int atoi) {
        assertThat(underTest.myAtoi(s)).isEqualTo(atoi);
    }
}
