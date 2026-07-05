package leetcode.p2492;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinScoreTest {

    private SolutionV1 v1;
    private SolutionV2 v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int n, int[][] roads, int minScore) {
        assertThat(v1.minScore(n, roads)).isEqualTo(minScore);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int n, int[][] roads, int minScore) {
        assertThat(v2.minScore(n, roads)).isEqualTo(minScore);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        4,
                        new int[][]{
                                {1, 2, 1},
                                {2, 3, 6},
                                {2, 4, 5},
                                {1, 4, 7}
                        },
                        1
                ),
                Arguments.of(
                        4,
                        new int[][]{
                                {1, 2, 9},
                                {2, 3, 6},
                                {2, 4, 5},
                                {1, 4, 7}
                        },
                        5
                ),
                Arguments.of(
                        4,
                        new int[][]{
                                {1, 2, 2},
                                {1, 3, 4},
                                {3, 4, 7}
                        },
                        2
                ),
                Arguments.of(
                        4,
                        new int[][]{
                                {1, 2, 2},
                                {1, 3, 4},
                                {3, 4, 7},
                                {4, 2, 1}
                        },
                        1
                ),
                Arguments.of(
                        5,
                        new int[][]{
                                {1, 2, 2},
                                {1, 3, 4},
                                {3, 4, 7},
                                {4, 2, 1},
                                {1, 5, 3}
                        },
                        1
                ),
                Arguments.of(
                        14,
                        new int[][]{
                                {2, 9, 2308}, {2, 5, 2150}, {12, 3, 4944}, {13, 5, 5462},
                                {2, 10, 2187}, {2, 12, 8132}, {2, 13, 3666}, {4, 14, 3019},
                                {2, 4, 6759}, {2, 14, 9869}, {1, 10, 8147}, {3, 4, 7971},
                                {9, 13, 8026}, {5, 12, 9982}, {10, 9, 6459}
                        },
                        2150
                ),
                Arguments.of(
                        14,
                        new int[][]{
                                {12, 7, 2151}, {7, 2, 7116}, {11, 14, 8450}, {11, 2, 9954},
                                {1, 11, 3307}, {10, 7, 3561}, {10, 1, 4986}, {11, 7, 7674},
                                {14, 2, 1764}, {11, 12, 6608}, {14, 7, 1070}, {9, 8, 2287},
                                {14, 12, 6559}, {1, 2, 1450}, {2, 12, 9165}
                        },
                        1070
                ),
                Arguments.of(
                        6,
                        new int[][]{
                                {4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674},
                                {5, 6, 7852}, {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192},
                                {1, 3, 4065}, {1, 4, 7357}
                        },
                        1885
                )
        );
    }

}
