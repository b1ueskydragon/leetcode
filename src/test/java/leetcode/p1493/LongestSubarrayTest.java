package leetcode.p1493;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubarrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testLongestSubarray(int[] nums, int expected) {
        assertThat(underTest.longestSubarray(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testLongestSubarray() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1}, 3),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 1, 1}, 2),
                Arguments.of(new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0}, 3),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1}, 7),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, 8),
                Arguments.of(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1}, 7)
        );
    }

}
