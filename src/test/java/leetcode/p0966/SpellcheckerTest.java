package leetcode.p0966;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpellcheckerTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSpellchecker(String[] wordlist, String[] queries, String[] expected) {
        assertThat(underTest.spellchecker(wordlist, queries)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new String[]{"KiTe", "kite", "Hare", "hare"},
                        new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"},
                        new String[]{"kite", "KiTe", "KiTe", "Hare", "Hare", "", "", "KiTe", "", "KiTe"}
                ),
                Arguments.of(
                        new String[]{"paa", "poe"},
                        new String[]{"pue"},
                        new String[]{"paa"}
                ),
                Arguments.of(
                        new String[]{"zeo", "Zuo"},
                        new String[]{"zuo"},
                        new String[]{"Zuo"}
                ),
                Arguments.of(
                        new String[]{"ibc", "abc", "uBc", "UbC"},
                        new String[]{"Ubc"},
                        new String[]{"uBc"}
                )
        );
    }

}
