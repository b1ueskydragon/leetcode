package leetcode.p2411;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void smallestSubarrays(int[] nums, int[] expected) {
        assertThat(underTest.smallestSubarrays(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> smallestSubarrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 2, 1, 3}, new int[]{3, 3, 2, 2, 1}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 0, 1}, new int[]{18, 17, 16, 15, 14, 13, 12, 11, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }
}
