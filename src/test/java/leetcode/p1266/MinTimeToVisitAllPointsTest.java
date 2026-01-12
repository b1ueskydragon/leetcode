package leetcode.p1266;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinTimeToVisitAllPointsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinTimeToVisitAllPoints(int[][] points, int minTime) {
        assertThat(underTest.minTimeToVisitAllPoints(points)).isEqualTo(minTime);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1}, {3, 4}, {-1, 0}}, 7),
                Arguments.of(new int[][]{{3, 2}, {-2, 2}}, 5),
                Arguments.of(new int[][]{{3, 5}, {6, -1}}, 6),
                Arguments.of(new int[][]{{3, 5}, {6, -1}, {6, -2}}, 7),
                Arguments.of(new int[][]{{3, 5}, {6, -1}, {6, -2}, {6, -2}}, 7),
                Arguments.of(new int[][]{{3, 5}, {6, -1}, {6, -2}, {6, -2}, {6, -1}, {100, 99}, {0, 1}, {2, 2}, {3, 3}, {5, -3}, {-3, 5}}, 225)
        );
    }

}
