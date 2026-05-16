package leetcode.p0300;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfLISTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLengthOfLIS(int[] nums, int lis) {
        // Longest (strictly) Increasing Subsequence.
        assertThat(underTest.lengthOfLIS(nums)).isEqualTo(lis);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.of(new int[]{0, 1, 0, 3, 2, 3}, 4),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 1),
                Arguments.of(new int[]{-86, -60}, 2),
                Arguments.of(new int[]{-35, 27, -71, -24, -13, -13, 15, 10, 45, -75, -53, -75, 29, -39, -56, 44, 5, -39, -16, -18, 35, 5, -34, 47, -62, -56, -59, -72, -40, -70, -68, -25, -9, -11, 37, -46, -35, -18, 9, -54, 3, 0, 25, -34, -21, -73, -46, -26, -43, -18}, 9),
                Arguments.of(new int[]{-6030, -6031, -6032, -6033, -6034, -6035, -6036, -6037, -6038, -6039, -6040, -6041, -6042, -6043, -6044, -6045, -6046, -6047, -6048, -6049, -6050, -6051, -6052, -6053, -6054, -6055, -6056, -6057, -6058, -6059, -6060}, 1)
        );
    }

}
