package leetcode.p0796.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RotateStringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "abcde, cdeab, true",
            "abcde, abced, false",
            "abcajweiotjoijowijfiozn, oijowijfioznabcajweiotj, true",
            "ohbrwzxvxe, uornhegseo, false",
            "bbbacddceeb, ceebbbbacdd, true"
    })
    void testRotateString(String s, String goal, boolean expected) {
        assertThat(underTest.rotateString(s, goal)).isEqualTo(expected);
    }
}
