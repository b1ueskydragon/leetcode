package leetcode.p2799;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountCompleteSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCountCompleteSubarrays(int[] nums, int count) {
        assertThat(underTest.countCompleteSubarrays(nums)).isEqualTo(count);
    }

    static Stream<Arguments> testCountCompleteSubarrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 1, 2, 2}, 4),
                Arguments.of(new int[]{5, 5, 5, 5}, 10),
                Arguments.of(new int[]{2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 1}, 9)
        );
    }
}
