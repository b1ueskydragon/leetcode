package leetcode.p1358;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfSubstringsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "abcabc, 10",
            "aaabca, 7",
            "aabcabc, 14",
            "abc, 1",
            "abcaaaaaaaaaaaaaaaabca, 75"
    })
    void testNumberOfSubStrings(String s, int result) {
        assertThat(underTest.numberOfSubstrings(s)).isEqualTo(result);
    }

}
