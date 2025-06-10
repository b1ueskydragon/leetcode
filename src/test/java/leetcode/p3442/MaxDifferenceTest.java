package leetcode.p3442;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDifferenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaxDifference(String s, int maxDiff) {
        assertThat(underTest.maxDifference(s)).isEqualTo(maxDiff);
    }

    static Stream<Arguments> testMaxDifference() {
        return Stream.of(
                Arguments.of("aaaaabbc", 3),
                Arguments.of("abcabcab", 1),
                Arguments.of("mmsmsym", -1)
        );
    }
}
