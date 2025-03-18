package leetcode.p0875;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinEatingSpeedTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinEatingSpeed(int[] piles, int h, int minK) {
        assertThat(underTest.minEatingSpeed(piles, h)).isEqualTo(minK);
    }

    static Stream<Arguments> testMinEatingSpeed() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                // this may cause integer overflow, so use long type for `totalH`
                Arguments.of(new int[]{805306368, 805306368, 805306368}, 1000000000, 3)
        );
    }
}
