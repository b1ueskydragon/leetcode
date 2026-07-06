package leetcode.p1288;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveCoveredIntervalsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testRemoveCoveredIntervals(int[][] intervals, int remaining) {
        assertThat(underTest.removeCoveredIntervals(intervals)).isEqualTo(remaining);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 4},
                        {3, 6},
                        {2, 8},
                }, 2),
                Arguments.of(new int[][]{
                        {1, 4},
                        {2, 3}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 9},
                        {1, 5},
                        {1, 4},
                        {2, 8},
                        {2, 4},
                        {3, 6}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 4},
                        {2, 3}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 2},
                        {1, 4},
                        {3, 4}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 4},
                        {2, 3},
                        {3, 4}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 4},
                        {2, 3}
                }, 1),
                Arguments.of(new int[][]{
                        {1, 2},
                        {1, 4},
                        {3, 4}
                }, 1)
        );
    }

}
