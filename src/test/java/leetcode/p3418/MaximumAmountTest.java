package leetcode.p3418;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumAmountTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumAmount(int[][] coins, int best) {
        assertThat(underTest.maximumAmount(coins)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {-7, 12, 12, 13},
                                {-6, 19, 19, -6},
                                {9, -2, -10, 16},
                                {-4, 14, -10, -9}
                        },
                        60
                ),
                Arguments.of(
                        new int[][]{
                                {-4}
                        },
                        0
                ),
                Arguments.of(
                        new int[][]{
                                {0, 1, -1},
                                {1, -2, 3},
                                {2, -3, 4}
                        },
                        8
                ),
                Arguments.of(
                        new int[][]{
                                {1, -1, -2, -3, 4}
                        },
                        4
                )
        );
    }
}
