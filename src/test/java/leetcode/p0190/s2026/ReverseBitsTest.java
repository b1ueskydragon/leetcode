package leetcode.p0190.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseBitsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "10, 1342177280",
            "2, 1073741824",
            "43261596, 964176192",
            "2147483644, 1073741822",
            "2147483646, 2147483646",
            "0, 0"
    })
    void testReverseBits(int n, int expected) {
        assertThat(underTest.reverseBits(n)).isEqualTo(expected);
    }

}
