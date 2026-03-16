package leetcode.p0875.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinEatingSpeedTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinEatingSpeed(int[] piles, int h, int k) {
        assertThat(underTest.minEatingSpeed(piles, h)).isEqualTo(k);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 5, 30),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 6, 23),
                Arguments.of(new int[]{100, 1}, 2, 100),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{805306368, 805306368, 805306368}, 1000000000, 3),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8, 8),
                Arguments.of(new int[]{805306368, 1, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 1000000000, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368, 999, 999999999, 444999777, 805306368, 805306368, 805306368, 805306368, 805306368, 805306368}, 98989, 317676)
        );
    }
}
