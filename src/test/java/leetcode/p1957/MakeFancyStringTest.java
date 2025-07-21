package leetcode.p1957;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MakeFancyStringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "leeetcode, leetcode",
            "aaabaaaa, aabaa",
            "aab, aab",
            "bbbbbbbab, bbab",
            "a, a",
            "bbbabbbabbbabbbaaabbbaaa, bbabbabbabbaabbaa"
    })
    void testMakeFancyString(String s, String expected) {
        assertThat(underTest.makeFancyString(s)).isEqualTo(expected);
    }
}
