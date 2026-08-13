package leetcode.p2958;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubarrayLengthTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxSubarrayLength(int[] nums, int k, int expected) {
        assertThat(underTest.maxSubarrayLength(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                        1,
                        3
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1},
                        2,
                        5
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 4, 1},
                        1,
                        3
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 1, 2, 3, 1, 2},
                        2,
                        6
                ),
                Arguments.of(
                        new int[]{1, 2, 1, 2, 1, 2, 1, 2},
                        1,
                        2
                ),
                Arguments.of(
                        new int[]{5, 5, 5, 5, 5, 5, 5},
                        4,
                        4
                ),
                Arguments.of(
                        new int[]{1_000_000_000, 7, 1_000_000_000, 8, 9, 1_000_000_000},
                        2,
                        5
                ),
                Arguments.of(
                        new int[]{1, 2, 1, 2, 3, 1, 1},
                        2,
                        5
                )
        );
    }

}
