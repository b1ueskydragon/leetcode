package leetcode.p1935;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CanBeTypedWordsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, ad, 1",
            "leet code, e, 0",
            "j zihroobaqm mechvdxsapqjbueycvsakpmdsldztcxqov xgoblinn lgwheqdofkluacxtza baqxzlkp obvjwhoeooujrky, ca, 3"
    })
    void testCanBeTypedWords(String text, String brokenLetters, int expected) {
        assertThat(underTest.canBeTypedWords(text, brokenLetters)).isEqualTo(expected);
    }

}
