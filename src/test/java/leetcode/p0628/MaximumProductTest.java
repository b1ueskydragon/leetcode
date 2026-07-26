package leetcode.p0628;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumProductTest {

    private Solution2026 underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumProduct(int[] nums, int maxProduct) {
        assertThat(underTest.maximumProduct(nums)).isEqualTo(maxProduct);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        6
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        24
                ),
                Arguments.of(
                        new int[]{-1, -2, -3},
                        -6
                ),
                Arguments.of(
                        new int[]{-100, -98, -1, 2, 3, 4},
                        39200
                ),
                Arguments.of(
                        new int[]{-10, -10, 1, 2, 30},
                        3000
                ),
                Arguments.of(
                        new int[]{0, -1, 0, -2, -1, 1},
                        2
                ),
                Arguments.of(
                        new int[]{-2, -3, -1, 0, -8},
                        0
                ),
                Arguments.of(
                        new int[]{-9, 2, -10, 5, -3, 8, -7, 4, -1},
                        720
                )
        );
    }

}
