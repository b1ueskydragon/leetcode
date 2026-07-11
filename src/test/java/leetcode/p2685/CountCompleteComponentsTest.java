package leetcode.p2685;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountCompleteComponentsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCountCompleteComponents(int n, int[][] edges) {
        assertThat(underTest.countCompleteComponents(n, edges));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 3},
                                {1, 3},
                                {2, 4}
                        },
                        3
                ),
                Arguments.of(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 4},
                                {3, 5}
                        },
                        1
                ),
                Arguments.of(
                        4,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {2, 3},
                                {1, 3},
                                {0, 3}
                        },
                        0
                ),
                Arguments.of(
                        5,
                        new int[][]{
                                {1, 2},
                                {3, 4},
                                {1, 4},
                                {2, 3},
                                {1, 3},
                                {2, 4}
                        },
                        2
                ),
                Arguments.of(
                        7,
                        new int[][]{
                                {4, 6},
                                {5, 6},
                                {0, 5},
                                {3, 1},
                                {2, 3}
                        },
                        0
                ),
                Arguments.of(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 4},
                                {3, 5},
                                {0, 3}
                        },
                        0
                ),
                Arguments.of(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 4},
                                {3, 5},
                                {1, 3}
                        },
                        0
                ),
                Arguments.of(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 5},
                                {1, 3}
                        },
                        1
                )
        );
    }

}
