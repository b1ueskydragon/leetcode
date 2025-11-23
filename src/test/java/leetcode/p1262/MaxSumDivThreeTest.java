package leetcode.p1262;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSumDivThreeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxSumDivThree(int[] nums, int maxSum) {
        assertThat(underTest.maxSumDivThree(nums)).isEqualTo(maxSum);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 4}, 12),
                Arguments.of(new int[]{3, 6, 5, 1, 8}, 18),
                Arguments.of(new int[]{4}, 0),
                Arguments.of(new int[]{2, 2, 2, 6, 7}, 15),
                Arguments.of(new int[]{8, 18, 24, 29, 46, 15, 42, 12, 33, 26, 40, 42, 20, 36, 1, 23, 50, 22, 15, 48, 25, 42, 46, 39, 7, 9, 21, 30, 5, 42, 35, 41, 25, 35, 26, 8, 44, 42, 22, 34, 41, 26, 47, 17, 4, 44, 15, 24, 33, 25, 46}, 1449)
        );
    }
}
