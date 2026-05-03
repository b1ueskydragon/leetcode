package leetcode.p0396;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxRotateFunctionTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxRotateFunction(int[] nums, int max) {
        assertThat(underTest.maxRotateFunction(nums)).isEqualTo(max);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 6}, 26),
                Arguments.of(new int[]{100}, 0),
                Arguments.of(new int[]{-100, 100, 0, -100, 100}, 200),
                Arguments.of(new int[]{41, -62, 76, -11, 41, 20, -27, -97, 77, -27, 28, -70, -15, 100, 63, 36, 59, 10, 22, 16}, 4259),
                Arguments.of(new int[]{97, 98, 91, 97, 95, 98, 100, 94, 93, 95, 90, 98, 99, 100, 98, 99, 94, 90, 91, 92}, 18337),
                Arguments.of(new int[]{-91, -20, -97, -63, -22, -54, -49, -35, -25, -65, -58, -87, -78, -11, -39, -27, -25, -1, -44, -28}, -7393)
        );
    }

}
