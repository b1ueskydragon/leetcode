package leetcode.p3047;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestSquareAreaTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLargestSquareArea(int[][] bottomLeft, int[][] topRight, int largestSquareArea) {
        assertThat(underTest.largestSquareArea(bottomLeft, topRight)).isEqualTo(largestSquareArea);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{3, 2}, {1, 1}}, new int[][]{{4, 5}, {5, 4}}, 1),
                Arguments.of(new int[][]{{1, 1}, {1, 3}, {1, 5}}, new int[][]{{5, 5}, {5, 7}, {5, 9}}, 4),
                Arguments.of(new int[][]{{1, 1}, {2, 2}, {1, 2}}, new int[][]{{3, 3}, {4, 4}, {3, 4}}, 1),
                Arguments.of(new int[][]{{1, 1}, {3, 3}, {3, 1}}, new int[][]{{2, 2}, {4, 4}, {4, 2}}, 0),
                Arguments.of(new int[][]{{2, 2}, {1, 2}}, new int[][]{{4, 4}, {3, 4}}, 1),
                Arguments.of(new int[][]{{2, 2}, {1, 2}}, new int[][]{{4, 4}, {3, 4}}, 1),
                Arguments.of(new int[][]{{1, 1}, {2, 2}, {3, 1}}, new int[][]{{3, 4}, {4, 4}, {6, 6}}, 1),
                Arguments.of(new int[][]{{3, 2}, {1, 2}}, new int[][]{{4, 5}, {5, 4}}, 1)
        );
    }

}
