package leetcode.p3392;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCountSubarrays(int[] nums, int count) {
        assertThat(underTest.countSubarrays(nums)).isEqualTo(count);
    }

    static Stream<Arguments> testCountSubarrays() {
        return Stream.of(
                Arguments.of(new int[]{7, 8, -3, -3, 8, 7, 20, 3}, 3),
                Arguments.of(new int[]{1, 1, 1}, 0)
        );
    }

}
