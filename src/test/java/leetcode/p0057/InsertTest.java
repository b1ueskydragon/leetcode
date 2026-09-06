package leetcode.p0057;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InsertTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testInsert(int[][] intervals, int[] newInterval, int[][] merged) {
        assertThat(underTest.insert(intervals, newInterval)).isEqualTo(merged);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{},
                        new int[]{2, 5},
                        new int[][]{{2, 5}}
                ),
                Arguments.of(
                        new int[][]{{3, 5}, {8, 10}},
                        new int[]{1, 2},
                        new int[][]{{1, 2}, {3, 5}, {8, 10}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{11, 12},
                        new int[][]{{1, 3}, {6, 9}, {11, 12}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{4, 7},
                        new int[][]{{1, 3}, {4, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {5, 6}},
                        new int[]{2, 5},
                        new int[][]{{1, 6}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {8, 10}},
                        new int[]{2, 9},
                        new int[][]{{1, 10}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                Arguments.of(
                        new int[][]{{0, 0}, {2, 4}, {9, 9}},
                        new int[]{0, 7},
                        new int[][]{{0, 7}, {9, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 5}},
                        new int[]{0, 3},
                        new int[][]{{0, 5}}
                )
        );
    }

}
