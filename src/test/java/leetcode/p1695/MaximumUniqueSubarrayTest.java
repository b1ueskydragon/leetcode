package leetcode.p1695;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumUniqueSubarrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaximumUniqueSubarray(int[] nums, int maxSum) {
        assertThat(underTest.maximumUniqueSubarray(nums)).isEqualTo(maxSum);
    }

    static Stream<Arguments> testMaximumUniqueSubarray() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 4, 5, 6}, 17),
                Arguments.of(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}, 8),
                Arguments.of(new int[]{1, 9, 7, 10, 7, 8, 8, 2, 2, 2, 3, 1, 5, 7, 7, 10, 10, 4, 3, 8}, 27),
                Arguments.of(new int[]{18, 8, 8, 19, 3, 1, 19, 1, 15, 13, 10, 4, 12, 2, 3, 3, 11, 4, 20, 11, 12, 4, 14, 9, 8, 1, 13, 15, 9, 20, 12, 13, 11, 8, 7, 8, 15, 10, 5, 17, 4, 10, 18, 5, 12, 18, 5, 16, 13, 2}, 107)
        );
    }
}
