package leetcode.p1391;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HasValidPathTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testHasValidPath(int[][] grid, boolean expected) {
        assertThat(underTest.hasValidPath(grid)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{6, 1, 3}, {4, 1, 5}}, true),
                Arguments.of(new int[][]{{4, 1, 3}, {6, 1, 2}}, true),
                Arguments.of(new int[][]{{2, 4, 3}, {6, 5, 2}}, true),
                Arguments.of(new int[][]{{1, 2, 1}, {1, 2, 1}}, false),
                Arguments.of(new int[][]{{1, 1, 2}}, false),
                Arguments.of(new int[][]{{1, 5}}, true),
                Arguments.of(new int[][]{{4, 3}, {6, 5}}, true),
                Arguments.of(new int[][]{{4, 3, 2}, {6, 5, 2}}, false)
        );
    }

}
