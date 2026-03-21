package leetcode.p3643;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseSubmatrixTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testReverseSubmatrix(int[][] grid, int x, int y, int k, int[][] expected) {
        assertThat(underTest.reverseSubmatrix(grid, x, y, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        1, 0, 3,
                        new int[][]{
                                {1, 2, 3, 4},
                                {13, 14, 15, 8},
                                {9, 10, 11, 12},
                                {5, 6, 7, 16}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                                {17, 18, 19, 20}
                        },
                        1, 0, 4,
                        new int[][]{
                                {1, 2, 3, 4},
                                {17, 18, 19, 20},
                                {13, 14, 15, 16},
                                {9, 10, 11, 12},
                                {5, 6, 7, 8},
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                                {17, 18, 19, 20}
                        },
                        0, 0, 4,
                        new int[][]{
                                {13, 14, 15, 16},
                                {9, 10, 11, 12},
                                {5, 6, 7, 8},
                                {1, 2, 3, 4},
                                {17, 18, 19, 20}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {3, 4, 2, 3},
                                {2, 3, 4, 2}
                        },
                        0, 2, 2,
                        new int[][]{
                                {3, 4, 4, 2},
                                {2, 3, 2, 3}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {6, 16, 14},
                                {1, 2, 19},
                                {14, 17, 15},
                                {18, 7, 6},
                                {14, 12, 5}
                        },
                        2, 1, 2,
                        new int[][]{
                                {6, 16, 14},
                                {1, 2, 19},
                                {14, 7, 6},
                                {18, 17, 15},
                                {14, 12, 5}
                        }
                ),
                Arguments.of(
                        new int[][]{{1}},
                        0, 0, 1,
                        new int[][]{{1}}
                )
        );
    }

}
