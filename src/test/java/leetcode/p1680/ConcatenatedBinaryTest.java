package leetcode.p1680;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConcatenatedBinaryTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "3, 27",
            "5, 1765",
            "12, 505379714",
            "100, 310828084",
            "100000, 757631812"
    })
    void testConcatenatedBinary(int n, int expected) {
        assertThat(underTest.concatenatedBinary(n)).isEqualTo(expected);
    }
}
