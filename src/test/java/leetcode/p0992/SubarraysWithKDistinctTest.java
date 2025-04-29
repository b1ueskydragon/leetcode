package leetcode.p0992;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SubarraysWithKDistinctTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testSubarraysWithKDistinct(int[] nums, int k, int count) {
        assertThat(underTest.subarraysWithKDistinct(nums, k)).isEqualTo(count);
    }

    static Stream<Arguments> testSubarraysWithKDistinct() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 3}, 2, 7),
                Arguments.of(new int[]{1, 2, 1, 3, 4}, 3, 3)
        );
    }
}
