package leetcode.p2492;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinScoreTest {

    private Solution v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinScore(int n, int[][] roads, int minScore) {
        assertThat(v1.minScore(n, roads)).isEqualTo(minScore);
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
                )
        );
    }

}
