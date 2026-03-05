package leetcode.p1758;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "10, 0",
            "0100, 1",
            "01001, 2",
            "1, 0",
            "0, 0",
            "111111111111111111111111111111111111111111111, 22",
            "1100001110101010101, 4",
            "00001110101010101, 3"
    })
    void testMinOperations(String s, int expected) {
        assertThat(underTest.minOperations(s)).isEqualTo(expected);
    }

}
