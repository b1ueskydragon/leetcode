package leetcode.p3567;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinAbsDiffTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinAbsDiff(int[][] grid, int k, int[][] expected) {
        assertThat(underTest.minAbsDiff(grid, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, -2, 3},
                                {2, 3, 5}
                        },
                        2,
                        new int[][]{{1, 2}}
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1}
                        },
                        4,
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0}
                        }
                )
        );
    }

}
