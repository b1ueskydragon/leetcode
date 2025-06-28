package leetcode.p0056;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    // Note: The production code may modify original `intervals` in-place
    @ParameterizedTest
    @MethodSource
    void testMerge(int[][] intervals, int[][] expected) {
        assertThat(underTest.merge(intervals)).isEqualTo(expected);
    }

    static Stream<Arguments> testMerge() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                        new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(
                        new int[][]{{1, 4}, {4, 5}},
                        new int[][]{{1, 5}}),
                Arguments.of(
                        new int[][]{{1, 4}, {0, 0}},
                        new int[][]{{0, 0}, {1, 4}}),
                Arguments.of(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}},
                        new int[][]{{1, 6}, {8, 11}, {15, 18}}),
                Arguments.of(
                        new int[][]{{1, 1}},
                        new int[][]{{1, 1}})
        );
    }
}
