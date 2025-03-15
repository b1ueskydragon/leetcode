package leetcode.p0424;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterReplacementTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "ABAB, 2, 4",
            "AABABBA, 1, 4",
            "AAABBC, 1, 4",
            "AACABBA, 2, 5"
    })
    void testCharacterReplacement(String s, int k, int maxWindowSize) {
        assertThat(underTest.characterReplacement(s, k)).isEqualTo(maxWindowSize);
    }
}
