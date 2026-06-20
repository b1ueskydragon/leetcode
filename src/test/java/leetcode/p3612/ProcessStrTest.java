package leetcode.p3612;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessStrTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "z*#, ''",
            "a#b%*, ba",
            "ab%#, baba",
            "ab%%#, abab",
            "ab*#, aa",
            "abc%%%, cba",
            "abc%#%#, abcabcabcabc",
            "abc###%, cbacbacbacbacbacbacbacba",
            "a###, aaaaaaaa",
            "%a%b%c%, cab",
            "a#*%, a",
            "a%#*, a"
    })
    void testProcessStr(String s, String after) {
        assertThat(underTest.processStr(s)).isEqualTo(after);
    }
}
