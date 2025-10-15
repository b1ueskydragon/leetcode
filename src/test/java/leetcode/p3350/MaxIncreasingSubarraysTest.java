package leetcode.p3350;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxIncreasingSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxIncreasingSubarrays(List<Integer> nums, int k) {
        assertThat(underTest.maxIncreasingSubarrays(nums)).isEqualTo(k);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3),
                Arguments.of(List.of(-2, -1, 0, 1, 2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 4),
                Arguments.of(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 2),
                Arguments.of(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 1, 2, 3, 4), 4),
                Arguments.of(List.of(-999999991, -999999993, -1000000000, -999999998, -999999991, -999999996, -999999993, -999999996, -999999994, -999999997, -999999997, -999999994, -999999993, -1000000000, -999999993, -999999996, -1000000000, -999999998, -999999990, -999999996, -999999996, -1000000000, -999999998, -999999991, -999999993, -999999999, -999999999, -999999997, -999999992, -999999997, -999999993, -999999998, -999999995, -999999990, -1000000000, -999999996, -999999992, -999999999, -999999992, -999999997, -999999994, -999999991, -999999993, -999999993, -1000000000, -1000000000, -999999998, -999999990, -999999996), 3)
        );
    }
}
