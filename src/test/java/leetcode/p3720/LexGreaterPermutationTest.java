package leetcode.p3720;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LexGreaterPermutationTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLexGreaterPermutation(String s, String target, String nextPermutation) {
        assertThat(underTest.lexGreaterPermutation(s, target)).isEqualTo(nextPermutation);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "abc",
                        "bba",
                        "bca"
                ),
                Arguments.of(
                        "leet",
                        "code",
                        "eelt"
                ),
                Arguments.of(
                        "bbbbdc",
                        "bbbbdz",
                        "bbbcbd"
                ),
                Arguments.of(
                        "abcdefg",
                        "zabcdef",
                        ""
                ),
                Arguments.of(
                        "abjijdowiehhgo",
                        "abjijdowiehhgo",
                        "abjijdowiehhog"
                ),
                Arguments.of(
                        "baba",
                        "bbaa",
                        ""
                ),
                Arguments.of(
                        "aaaabbbbaaa",
                        "aaaabbbbaaa",
                        "aaabaaaabbb"
                ),
                Arguments.of(
                        "abc",
                        "bdz",
                        "cab"
                )
        );
    }

}
