package leetcode.p1260;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShiftGridTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testShiftGrid(int[][] grid, int k, List<List<Integer>> shifted) {
        assertThat(underTest.shiftGrid(grid, k)).isEqualTo(shifted);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        1,
                        List.of(
                                List.of(9, 1, 2),
                                List.of(3, 4, 5),
                                List.of(6, 7, 8)
                        )
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        2,
                        List.of(
                                List.of(8, 9, 1),
                                List.of(2, 3, 4),
                                List.of(5, 6, 7)
                        )
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        9,
                        List.of(
                                List.of(1, 2, 3),
                                List.of(4, 5, 6),
                                List.of(7, 8, 9)
                        )
                ),
                Arguments.of(
                        new int[][]{
                                {3, 8, 1, 9},
                                {19, 7, 2, 5},
                                {4, 6, 11, 10},
                                {12, 0, 21, 13}
                        },
                        4,
                        List.of(
                                List.of(12, 0, 21, 13),
                                List.of(3, 8, 1, 9),
                                List.of(19, 7, 2, 5),
                                List.of(4, 6, 11, 10)
                        )
                ),
                Arguments.of(
                        new int[][]{
                                {3, 8, 1, 9},
                                {19, 7, 2, 5},
                                {4, 6, 11, 10},
                                {12, 0, 21, 13}
                        },
                        7,
                        List.of(
                                List.of(6, 11, 10, 12),
                                List.of(0, 21, 13, 3),
                                List.of(8, 1, 9, 19),
                                List.of(7, 2, 5, 4)
                        )
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2},
                                {4, 5},
                                {8, 9},
                                {11, 12}
                        },
                        97,
                        List.of(
                                List.of(12, 1),
                                List.of(2, 4),
                                List.of(5, 8),
                                List.of(9, 11)
                        )
                )
        );
    }

}
