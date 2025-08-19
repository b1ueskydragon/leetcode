package leetcode.p2348;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroFilledSubarrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void zeroFilledSubarray(int[] nums, long expected) {
        assertThat(underTest.zeroFilledSubarray(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> zeroFilledSubarray() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0, 2, 0, 0}, 9),
                Arguments.of(new int[]{0, 0, 0, 2, 0, 0, 2}, 9),
                Arguments.of(new int[]{1, 3, 0, 0, 2, 0, 0, 4}, 6),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 55),
                Arguments.of(new int[]{2, 10, 2019}, 0)
        );
    }

}
