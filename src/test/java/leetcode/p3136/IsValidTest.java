package leetcode.p3136;

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
            "bcdfghjklmnp, false",
            "bcdfghjaklmnp, true",
            "a3$e, false",
            "b3, false",
            "aeiouAEIOU1, false",
            "aeiouAEIOU, false",
            "aeiouAEIbOU, true"
    })
    void testIsValid(String word, boolean expected) {
        assertThat(underTest.isValid(word)).isEqualTo(expected);
    }

}
