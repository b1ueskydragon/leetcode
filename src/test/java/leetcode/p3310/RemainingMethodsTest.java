package leetcode.p3310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemainingMethodsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testRemainingMethods(int n, int k, int[][] invocations, List<Integer> expected) {
        assertThat(underTest.remainingMethods(n, k, invocations)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        6,
                        0,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {0, 5},
                                {1, 2},
                                {2, 4}
                        },
                        List.of(3)
                ),
                Arguments.of(
                        7,
                        6,
                        new int[][]{
                                {6, 3}, {2, 6}, {3, 1}, {5, 4}, {6, 1}, {1, 0},
                                {0, 6}, {2, 3}, {5, 0}, {4, 0}, {5, 2}, {1, 3},
                                {5, 3}, {2, 5}, {4, 3}, {3, 2}, {2, 0}, {4, 1},
                                {5, 6}, {2, 1}, {3, 0}, {1, 4}, {5, 1}, {3, 5},
                                {6, 2}, {3, 4}, {4, 6}, {0, 1}, {0, 5}, {2, 4},
                                {1, 6}, {6, 0}, {1, 2}, {1, 5}, {6, 5}, {3, 6},
                                {0, 4}, {6, 4}
                        },
                        List.of()
                )
        );
    }

}
