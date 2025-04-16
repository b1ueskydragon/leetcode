package leetcode.p2537;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountGoodTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCountGood(int[] nums, int k, long subArrays) {
        assertThat(underTest.countGood(nums, k)).isEqualTo(subArrays);
    }

    static Stream<Arguments> testCountGood() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1, 3, 2}, 3, 1),
                Arguments.of(new int[]{1000000000, 9, 1000000000, 1000000000, 9, 1000000000}, 2, 6),
                // r++ の前に pairs - combination(prevCnt) しないと, 余分な pair が累積されてしまうケース
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 10, 1),
                // l++ の前に pairs + combination(headCnt - 1) しないと, 過剰な pair 減少になってしまうケース
                Arguments.of(new int[]{1, 1, 1, 1}, 3, 3)
        );
    }
}
