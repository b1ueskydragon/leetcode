package leetcode.p0868.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryGapTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "15, 1",
            "9, 3",
            "22, 2",
            "8, 0",
            "999999999, 3",
            "1000000000, 3",
            "72453911, 4"
    })
    void testBinaryGap(int n, int expected) {
        assertThat(underTest.binaryGap(n)).isEqualTo(expected);
    }
}
