package leetcode.p0020.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsValidTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "(), true",
            "(}{), false",
            "()[]{}, true",
            "(], false",
            "([]), true",
            "([)], false",
            "){, false",
            "((, false",
            "], false"
    })
    void testIsValid(String s, boolean expected) {
        assertThat(underTest.isValid(s)).isEqualTo(expected);
    }
}
