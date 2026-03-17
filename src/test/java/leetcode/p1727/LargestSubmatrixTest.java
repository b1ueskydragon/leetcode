package leetcode.p1727;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestSubmatrixTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLargestSubmatrix(int[][] matrix, int max) {
        assertThat(underTest.largestSubmatrix(matrix)).isEqualTo(max);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 1},
                                {1, 1, 1},
                                {1, 0, 1}
                        },
                        4
                ),
                Arguments.of(
                        new int[][]{
                                {1, 0, 1, 0, 1}
                        },
                        3
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 0},
                                {1, 0, 1},
                        },
                        2
                ),
                Arguments.of(
                        new int[][]{
                                {1, 0, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        },
                        3
                ),
                Arguments.of(
                        new int[][]{
                                {0, 0, 1},
                                {1, 1, 0},
                                {1, 0, 1},
                                {1, 0, 1},
                                {0, 0, 0},
                                {1, 0, 1},
                                {0, 0, 1},
                                {0, 1, 0},
                                {1, 0, 0},
                                {1, 0, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        },
                        4
                )
        );
    }

}
