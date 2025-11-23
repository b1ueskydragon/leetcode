package leetcode.p1930;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountPalindromicSubsequenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "aabca, 3",
            "adc, 0",
            "bbcbaba, 4",
            "abcdefghijklmnopqrstuvwxyzzzzzzzzzzzbzzzzzzzzzaaaaaazzzxyzz, 63"
    })
    void countPalindromicSubsequence(String s, int count) {
        assertThat(underTest.countPalindromicSubsequence(s)).isEqualTo(count);
    }

}
