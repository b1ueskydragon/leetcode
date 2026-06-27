package leetcode.p3737;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountMajoritySubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCountMajoritySubarrays(int[] nums, int target, int maxCount) {
        assertThat(underTest.countMajoritySubarrays(nums, target)).isEqualTo(maxCount);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 2, 3},
                        2,
                        5
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1},
                        1,
                        10
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        4,
                        0
                ),
                Arguments.of(
                        new int[]{1, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1},
                        2,
                        292
                )
        );
    }

}
