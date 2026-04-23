package leetcode.p2615;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testDistance(int[] nums, long[] sumOfDistances) {
        assertThat(underTest.distance(nums)).isEqualTo(sumOfDistances);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 1, 1, 2}, new long[]{5, 0, 3, 4, 0}),
                Arguments.of(new int[]{1, 3, 1, 2, 1, 2}, new long[]{6, 0, 4, 2, 6, 2}),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, new long[]{10, 7, 6, 7, 10}),
                Arguments.of(new int[]{2, 0, 2, 2, 6, 5, 2}, new long[]{11, 0, 7, 7, 0, 0, 13}),
                Arguments.of(new int[]{2, 0, 2, 2, 2, 6, 5, 2}, new long[]{16, 0, 10, 9, 10, 0, 0, 19}),
                Arguments.of(new int[]{3, 8, 2, 0, 2, 2, 2, 6, 5, 2, 4, 7}, new long[]{0, 0, 16, 0, 10, 9, 10, 0, 0, 19, 0, 0}),
                Arguments.of(new int[]{0, 5, 3}, new long[]{0, 0, 0})
        );
    }

}
