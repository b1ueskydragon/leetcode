package leetcode.p3228;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1001101, 4",
            "00111, 0",
            "00110101, 5",
            "10011001, 4",
            "011010, 5"
    })
    void testMaxOperation(String s, int expected) {
        assertThat(underTest.maxOperations(s)).isEqualTo(expected);
    }
}
