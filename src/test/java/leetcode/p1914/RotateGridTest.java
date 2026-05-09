package leetcode.p1914;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateGridTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testRotateGrid(int[][] grid, int k, int[][] rotated) {
        assertThat(underTest.rotateGrid(grid, k)).isEqualTo(rotated);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {40, 10},
                                {30, 20}
                        },
                        1,
                        new int[][]{
                                {10, 20},
                                {40, 30}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        2,
                        new int[][]{
                                {3, 4, 8, 12},
                                {2, 11, 10, 16},
                                {1, 7, 6, 15},
                                {5, 9, 13, 14}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4, 5, 6},
                                {7, 8, 9, 10, 11, 12},
                                {13, 14, 15, 16, 17, 18},
                                {19, 20, 21, 22, 23, 24},
                                {25, 26, 27, 28, 29, 30},
                                {31, 32, 33, 34, 35, 36}
                        },
                        2,
                        new int[][]{
                                {3, 4, 5, 6, 12, 18},
                                {2, 10, 11, 17, 23, 24},
                                {1, 9, 22, 21, 29, 30},
                                {7, 8, 16, 15, 28, 36},
                                {13, 14, 20, 26, 27, 35},
                                {19, 25, 31, 32, 33, 34}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4, 5, 6},
                                {7, 8, 9, 10, 11, 12},
                                {13, 14, 15, 16, 17, 18},
                                {19, 20, 21, 22, 23, 24},
                                {25, 26, 27, 28, 29, 30},
                                {31, 32, 33, 34, 35, 36}
                        },
                        1098423,
                        new int[][]{
                                {4, 5, 6, 12, 18, 24},
                                {3, 11, 17, 23, 29, 30},
                                {2, 10, 21, 15, 28, 36},
                                {1, 9, 22, 16, 27, 35},
                                {7, 8, 14, 20, 26, 34},
                                {13, 19, 25, 31, 32, 33}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8}
                        },
                        6,
                        new int[][]{
                                {6, 5, 1, 2},
                                {7, 8, 4, 3}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4, 5, 6},
                                {7, 8, 9, 10, 11, 12}
                        },
                        1111111,
                        new int[][]{
                                {11, 10, 9, 8, 7, 1},
                                {12, 6, 5, 4, 3, 2}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2},
                                {7, 8},
                                {13, 14},
                                {19, 20},
                                {25, 26},
                                {31, 32}
                        },
                        1111111,
                        new int[][]{
                                {31, 25},
                                {32, 19},
                                {26, 13},
                                {20, 7},
                                {14, 1},
                                {8, 2}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {2, 1},
                                {2, 1},
                                {2, 1},
                                {1, 2}
                        },
                        1,
                        new int[][]{
                                {1, 1},
                                {2, 1},
                                {2, 2},
                                {2, 1}
                        }
                )
        );
    }

}
