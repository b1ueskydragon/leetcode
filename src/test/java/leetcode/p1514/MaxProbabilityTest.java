package leetcode.p1514;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProbabilityTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode, double maxProb) {
        assertThat(underTest.maxProbability(n, edges, succProb, startNode, endNode))
                .isCloseTo(maxProb, Percentage.withPercentage(1e-5));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        5,
                        new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
                        new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04},
                        3,
                        4,
                        0.21390
                ),
                Arguments.of(
                        10,
                        new int[][]{{3, 5}, {3, 4}, {6, 8}, {1, 5}, {2, 8}, {6, 9}, {0, 2}, {7, 8}, {0, 4}, {3, 7}, {8, 9}, {5, 8}, {3, 6}, {0, 6}, {1, 6}, {0, 1}, {0, 3}, {5, 6}, {1, 9}},
                        new double[]{0.72, 0.81, 0.18, 0.62, 0.96, 0.45, 0.19, 0.77, 0.1, 0.99, 0.49, 0.25, 0.45, 0.68, 0.95, 0.61, 0.11, 0.72, 0.2},
                        1,
                        6,
                        0.95000
                ),
                Arguments.of(
                        10,
                        new int[][]{{3, 5}, {3, 4}, {6, 8}, {1, 5}, {2, 8}, {6, 9}, {0, 2}, {7, 8}, {0, 4}, {3, 7}, {8, 9}, {5, 8}, {3, 6}, {0, 6}, {1, 6}, {0, 1}, {0, 3}, {5, 6}, {1, 9}},
                        new double[]{0.72, 0.81, 0.18, 0.62, 0.96, 0.45, 0.19, 0.77, 0.1, 0.99, 0.49, 0.25, 0.45, 0.68, 0.95, 0.61, 0.11, 0.72, 0.2},
                        5,
                        3,
                        0.72000
                ),
                Arguments.of(
                        500,
                        new int[][]{{193, 229}, {133, 212}, {224, 465}},
                        new double[]{0.91, 0.78, 0.64},
                        4,
                        364,
                        0.00000
                ),
                Arguments.of(
                        3,
                        new int[][]{{1, 2}},
                        new double[]{0.5},
                        0,
                        1,
                        0.00000
                )
        );
    }

}
