package leetcode.p3105;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestMonotonicSubarrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLongestMonotonicSubarray(int[] nums, int theLongest) {
        assertThat(underTest.longestMonotonicSubarray(nums)).isEqualTo(theLongest);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 3, 3, 2}, 2),
                Arguments.of(new int[]{3, 3, 3, 3}, 1),
                Arguments.of(new int[]{3, 2, 1}, 3),
                Arguments.of(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 2, 3, 3, 1, 2, 3, 6, 8, 9, 10, 12, 3, 2, 1, 2}, 8)
        );
    }

}
