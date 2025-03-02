package leetcode.p2384;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LargestPalindromicTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
        "1799, 979",
        "444947137, 7449447",
        "192838331928881, 9883218123889",
        // edge case: zero cannot be a head (or a last)
        "00009, 9",
        // edge case: but we still should append zero as a body
        "00001105, 1005001",
        // edge case: all zeros
        "0000000, 0"
    })
    void testLargestPalindromic(String num, String theLargestResult) {
        assertThat(underTest.largestPalindromic(num)).isEqualTo(theLargestResult);
    }
}
