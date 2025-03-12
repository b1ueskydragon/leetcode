package leetcode.p2529;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCountTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaximumCount(int[] nums, int result) {
        assertThat(underTest.maximumCount(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testMaximumCount() {
        return Stream.of(
                Arguments.of(new int[]{-2, -1, -1, -1, -1, 1, 2, 3}, 5),
                Arguments.of(new int[]{-3, -2, -1, 0, 0, 1, 2}, 3),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 5, 20, 66, 1314}, 4),
                Arguments.of(new int[]{5, 20, 66, 1314}, 4),
                Arguments.of(new int[]{-1563, -236, -114, -55, 427, 447, 687, 752, 1021, 1636}, 6),
                Arguments.of(new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0}, 1),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0)
        );
    }
}
