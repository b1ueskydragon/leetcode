package leetcode.p0756;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PyramidTransitionTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPyramidTransition(String bottom, List<String> allowed, boolean result) {
        assertThat(underTest.pyramidTransition(bottom, allowed)).isEqualTo(result);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("AAAA", List.of("AAB", "AAC", "BCD", "BBE", "DEF"), false),
                Arguments.of("AAAA", List.of("AAB", "AAC", "BCD", "BBE", "DEF"), false),
                Arguments.of("ABCDF", List.of("BCE", "BCF", "ABA", "CDA", "AEF", "FAF", "FFF"), false),
                Arguments.of("EEF", List.of("BCE", "BCF", "ABA", "CDA", "AEF", "FAF", "FFF"), false),
                Arguments.of("BCDE", List.of("DEF", "BCC", "CDE", "CEA", "FFF", "EFB", "ABD"), true),
                Arguments.of("AAAA", List.of("AAB", "AAC", "BCD", "BBE", "DEF", "EDD"), true)
        );
    }

}
