package leetcode.p0812;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestTriangleAreaTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLargestTriangleArea(int[][] points, double expected) {
        assertThat(underTest.largestTriangleArea(points)).isCloseTo(expected, Percentage.withPercentage(1e-5));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}, 2.00000),
                Arguments.of(new int[][]{{1, 0}, {0, 0}, {0, 1}}, 0.50000),
                Arguments.of(new int[][]{{1, 1}, {3, 2}, {2, 7}}, 5.50000),
                Arguments.of(new int[][]{{8, 3}, {5, 6}, {3, 5}}, 4.50000)
        );
    }

}
