package leetcode.p1935;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CanBeTypedWordsTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(String text, String brokenLetters, int expected) {
        assertThat(v2.canBeTypedWords(text, brokenLetters)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(String text, String brokenLetters, int expected) {
        assertThat(v1.canBeTypedWords(text, brokenLetters)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("hello world", "ad", 1),
                Arguments.of("leet code", "e", 0),
                Arguments.of("j zihroobaqm mechvdxsapqjbueycvsakpmdsldztcxqov xgoblinn lgwheqdofkluacxtza baqxzlkp obvjwhoeooujrky", "ca", 3)
        );
    }

}
