package leetcode.p1722;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumHammingDistanceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps, int diffs) {
        assertThat(underTest.minimumHammingDistance(source, target, allowedSwaps)).isEqualTo(diffs);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{2, 1, 4, 5},
                        new int[][]{{0, 1}, {2, 3}},
                        1
                ),
                Arguments.of(
                        new int[]{5, 1, 2, 4, 3},
                        new int[]{1, 5, 4, 2, 3},
                        new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}},
                        0
                ),
                Arguments.of(
                        new int[]{41, 37, 51, 100, 25, 33, 90, 49, 65, 87, 11, 18, 15, 18},
                        new int[]{41, 92, 69, 75, 29, 13, 53, 21, 17, 81, 33, 19, 33, 32},
                        new int[][]{{0, 11}, {5, 9}, {6, 9}, {5, 7}, {8, 13}, {4, 8}, {12, 7}, {8, 2}, {13, 5}, {0, 7}, {6, 4}, {8, 9}, {4, 12}, {6, 1}, {10, 0}, {10, 2}, {7, 3}, {11, 10}, {5, 2}, {11, 1}, {3, 0}, {8, 5}, {12, 6}, {2, 1}, {11, 2}, {4, 9}, {2, 9}, {10, 6}, {12, 10}, {4, 13}, {13, 2}, {11, 9}, {3, 6}, {0, 4}, {1, 10}, {5, 11}, {12, 1}, {10, 4}, {6, 2}, {10, 7}, {3, 13}, {4, 5}, {13, 10}, {4, 7}, {0, 12}, {9, 10}, {9, 3}, {0, 5}, {1, 9}, {5, 10}, {8, 0}, {12, 11}, {11, 4}, {7, 9}, {7, 2}, {13, 9}, {12, 3}, {8, 6}, {7, 6}, {8, 12}, {4, 3}, {7, 13}, {0, 13}, {2, 0}, {3, 8}, {8, 1}, {13, 6}, {1, 4}, {0, 9}, {2, 3}, {8, 7}, {4, 2}, {9, 12}},
                        12
                )
        );
    }

}
