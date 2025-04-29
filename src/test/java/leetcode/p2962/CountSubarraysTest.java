package leetcode.p2962;

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
    void testCountSubarrays(int[] nums, int k, int count) {
        assertThat(underTest.countSubarrays(nums, k)).isEqualTo(count);
    }

    static Stream<Arguments> testCountSubarrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 3, 3}, 2, 6),
                Arguments.of(new int[]{1, 4, 2, 1}, 3, 0),
                Arguments.of(new int[]{
                        999991, 999999, 999991, 999998, 999990, 999998, 999991, 999990, 999991, 999998}, 1, 18),
                Arguments.of(new int[]{1}, 9, 0),
                Arguments.of(new int[]{1}, 1, 1)
        );
    }

}
