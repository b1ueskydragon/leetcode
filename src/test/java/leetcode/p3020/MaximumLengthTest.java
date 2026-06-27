package leetcode.p3020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumLengthTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumLength(int[] nums, int maxLen) {
        assertThat(underTest.maximumLength(nums)).isEqualTo(maxLen);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 16, 4, 16, 2, 5}, 3),
                Arguments.of(new int[]{2, 256, 2}, 1),
                Arguments.of(new int[]{5, 4, 1, 2, 2}, 3),
                Arguments.of(new int[]{1, 3, 2, 4}, 1),
                Arguments.of(new int[]{31622, 31622, 31623, 31624, 999950884}, 3),
                Arguments.of(new int[]{31622, 31623, 31624, 999950883}, 1),
                Arguments.of(new int[]{2, 2, 4, 4, 16, 16, 256}, 7),
                Arguments.of(new int[]{2, 4, 4, 16, 16, 256}, 5),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 1, 1}, 3),
                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 5),
                Arguments.of(new int[]{14, 14, 196, 196, 38416, 38416}, 5),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}, 9)
        );
    }

}
