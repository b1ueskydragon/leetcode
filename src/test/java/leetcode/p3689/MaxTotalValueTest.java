package leetcode.p3689;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTotalValueTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxTotalValue(int[] nums, int k, long maxTotalValue) {
        assertThat(underTest.maxTotalValue(nums, k)).isEqualTo(maxTotalValue);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 2},
                        2,
                        4L
                ),
                Arguments.of(
                        new int[]{4, 2, 5, 1},
                        3,
                        12L
                ),
                Arguments.of(
                        new int[]{956176490, 942896924, 1000000000, 903100177, 947477293, 903783645, 947092588, 941603252, 970480280},
                        10000,
                        968998230000L
                ),
                Arguments.of(
                        new int[]{1},
                        10000,
                        0L
                ),
                Arguments.of(
                        new int[]{1000000000},
                        1,
                        0L
                ),
                Arguments.of(
                        new int[]{1000000000},
                        10000,
                        0L
                ),
                Arguments.of(
                        new int[]{0, 1000000000},
                        10000,
                        10000000000000L
                )
        );
    }

}
