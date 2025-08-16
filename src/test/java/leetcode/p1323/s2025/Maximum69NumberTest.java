package leetcode.p1323.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Maximum69NumberTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "9669, 9969",
            "6666, 9666",
            "9696, 9996",
            "6969, 9969",
            "6, 9",
            "9, 9",
            "9999, 9999"
    })
    void testMaximum69Number(int num, int expected) {
        assertThat(underTest.maximum69Number(num)).isEqualTo(expected);
    }

}
