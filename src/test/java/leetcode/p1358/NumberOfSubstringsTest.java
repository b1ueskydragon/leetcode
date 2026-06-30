package leetcode.p1358;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfSubstringsTest {

    private Solution s2026;
    private Solution s2025;

    @BeforeEach
    void setUp() {
        s2026 = new Solution2026();
        s2025 = new Solution2025();
    }

    @ParameterizedTest
    @CsvSource({
            "abcabc, 10",
            "aaabca, 7",
            "aabcabc, 14",
            "abc, 1",
            "abcaaaaaaaaaaaaaaaabca, 75",
            "aaaabbbbcccccbbbbbbbbbaaac, 117",
            "aab, 0"
    })
    void testNumberOfSubStrings(String s, int result) {
        assertThat(s2026.numberOfSubstrings(s)).isEqualTo(result);
        assertThat(s2025.numberOfSubstrings(s)).isEqualTo(result);
    }

}
