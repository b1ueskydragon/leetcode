package leetcode.p2515;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClosestTargetTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testClosestTarget(String[] words, String target, int startIndex, int best) {
        assertThat(underTest.closestTarget(words, target, startIndex)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new String[]{"pgmiltbptl", "jnkxwutznb", "bmeirwjars", "ugzyaufzzp", "pgmiltbptl", "sfhtxkmzwn", "pgmiltbptl", "pgmiltbptl", "onvmgvjhxa", "jyzdtwbwqp"},
                        "pgmiltbptl",
                        4,
                        0
                ),
                Arguments.of(
                        new String[]{"hello", "i", "am", "leetcode", "hello"},
                        "hello",
                        1,
                        1
                ),
                Arguments.of(
                        new String[]{"a", "b", "leetcode"},
                        "leetcode",
                        0,
                        1
                ),
                Arguments.of(
                        new String[]{"i", "eat", "leetcode"},
                        "ate",
                        0,
                        -1
                )
        );
    }

}
