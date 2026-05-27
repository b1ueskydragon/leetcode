package leetcode.p3121;

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
            "abBCab, 0",
            "aZaAzzzawieoriHmnhnbbnk, 0",
            "BA, 0",
            "ab, 0",
            "aaaaaaaaAa, 0",
            "aaaaaaaaaa, 0 ",
            "aaaaaaaaaA, 1",
            "aaaaaaaaaB, 0",
            "aaaaaaaaaBA, 1",
            "aaaaaaaaaBbA, 1",
            "aaaaaaaaabBA, 2",
            "a, 0",
            "A, 0"
    })
    void testNumberOfSpecialChars(String word, int count) {
        assertThat(underTest.numberOfSpecialChars(word)).isEqualTo(count);
    }

}
