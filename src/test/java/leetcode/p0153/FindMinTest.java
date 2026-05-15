package leetcode.p0153;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMinTest {

    private Solution s2020;
    private Solution s2026;

    @BeforeEach
    void setUp() {
        s2020 = new leetcode.p0153.s2020.Solution();
        s2026 = new leetcode.p0153.s2026.Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2020(int[] nums, int min) {
        assertThat(s2020.findMin(nums)).isEqualTo(min);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2026(int[] nums, int min) {
        assertThat(s2026.findMin(nums)).isEqualTo(min);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 1),
                Arguments.of(new int[]{6, 1, 2, 3, 4, 5}, 1),
                Arguments.of(new int[]{5, 6, 1, 2, 3, 4}, 1),
                Arguments.of(new int[]{4, 5, 6, 1, 2, 3}, 1),
                Arguments.of(new int[]{3, 4, 5, 6, 1, 2}, 1),
                Arguments.of(new int[]{2, 3, 4, 5, 6, 1}, 1),
                Arguments.of(new int[]{11, 21, 61, 77, 88}, 11),
                Arguments.of(new int[]{88, 11, 21, 61, 77}, 11),
                Arguments.of(new int[]{77, 88, 11, 21, 61}, 11),
                Arguments.of(new int[]{61, 77, 88, 11, 21}, 11),
                Arguments.of(new int[]{21, 62, 77, 88, 11}, 11)
        );
    }

}
