package leetcode.p3120;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfSpecialCharsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "aaAbcBC, 3",
            "abc, 0",
            "abBCab, 1",
            "aZaAzzzawieoriHmnhnbbnk, 3",
            "BA, 0",
            "ab, 0"
    })
    void testNumberOfSpecialChars(String word, int count) {
        assertThat(underTest.numberOfSpecialChars(word)).isEqualTo(count);
    }

}
