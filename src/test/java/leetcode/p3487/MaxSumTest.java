package leetcode.p3487;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void maxSum(int[] nums, int expected) {
        assertThat(underTest.maxSum(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> maxSum() {
        return Stream.of(
                Arguments.of(new int[]{-7, -6, -6, -6, 0, -4, -8, -3, -2, -7}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
                Arguments.of(new int[]{-100}, -100),
                Arguments.of(new int[]{0, 3, -10, -9, 6, -9, 2, 7, -2, -8}, 18),
                Arguments.of(new int[]{6, 4, 6, 1, 4, 2, -2, -7, 5, -6}, 18)
        );
    }
}
