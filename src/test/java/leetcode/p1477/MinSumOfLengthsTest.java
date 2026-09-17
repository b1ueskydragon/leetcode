package leetcode.p1477;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinSumOfLengthsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinSumOfLengths(int[] arr, int target, int minLenSum) {
        assertThat(underTest.minSumOfLengths(arr, target)).isEqualTo(minLenSum);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{7, 3, 4, 7},
                        7,
                        2
                ),
                Arguments.of(
                        new int[]{2, 3, 2, 2, 5},
                        7,
                        5
                ),
                Arguments.of(
                        new int[]{3, 2, 2, 4, 3},
                        3,
                        2
                ),
                Arguments.of(
                        new int[]{1, 6, 1},
                        7,
                        -1
                ),
                Arguments.of(
                        new int[]{2, 2, 2, 2},
                        4,
                        4
                ),
                Arguments.of(
                        new int[]{5, 1, 1, 1, 5},
                        6,
                        4
                ),
                Arguments.of(
                        new int[]{4, 3, 2, 6, 2, 3, 4},
                        9,
                        6
                ),
                Arguments.of(
                        new int[]{8, 1, 1, 1, 1, 8},
                        10,
                        6
                ),
                Arguments.of(
                        new int[]{1, 2, 2, 3, 2, 2, 1},
                        5,
                        5
                ),
                Arguments.of(
                        new int[]{1000, 1, 999, 1000, 1000},
                        2000,
                        5
                )
        );
    }

}
