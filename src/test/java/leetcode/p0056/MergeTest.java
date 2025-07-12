package leetcode.p0056;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    private Solution.V1 v1;
    private Solution.V2 v2;
    private Solution.V3 v3;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
        v3 = new Solution.V3();
    }

    // Note: The production code may modify original `intervals` in-place
    @ParameterizedTest
    @MethodSource("testMerge")
    void testV1(int[][] intervals, int[][] expected) {
        assertThat(v1.merge(intervals)).isEqualTo(expected);
    }

    // Note: The production code may modify original `intervals` in-place
    @ParameterizedTest
    @MethodSource("testMerge")
    void testV2(int[][] intervals, int[][] expected) {
        assertThat(v2.merge(intervals)).isEqualTo(expected);
    }

    // Note: The production code may modify original `intervals` in-place
    @ParameterizedTest
    @MethodSource("testMerge")
    void testV3(int[][] intervals, int[][] expected) {
        assertThat(v3.merge(intervals)).isEqualTo(expected);
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
