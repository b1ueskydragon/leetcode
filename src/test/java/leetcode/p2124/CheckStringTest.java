package leetcode.p2124;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CheckStringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "ababababababa, false",
            "bbbbbbbbbbab, false",
            "aaaaaaaaaaaaaaaab, true",
            "aaaaaaaaaaaaaaaaaba, false"
    })
    void testCheckString(String s, boolean expected) {
        assertThat(underTest.checkString(s)).isEqualTo(expected);
    }

}
