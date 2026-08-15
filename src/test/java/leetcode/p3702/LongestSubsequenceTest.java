package leetcode.p3702;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubsequenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLongestSubsequence(int[] nums, int theLongestSubSeq) {
        assertThat(underTest.longestSubsequence(nums)).isEqualTo(theLongestSubSeq);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{2, 3, 4}, 3),
                Arguments.of(new int[]{1, 7, 6, 2, 3, 5, 4, 2}, 8),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 9),
                Arguments.of(new int[]{1, 1, 2, 2, 3, 3}, 5),
                Arguments.of(new int[]{0, 0, 2, 0, 4, 0, 6, 0, 0, 0}, 9),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1}, 10),
                Arguments.of(new int[]{1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1}, 11),
                Arguments.of(new int[]{1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 4, 1}, 12),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 8),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 7),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, 7),
                Arguments.of(new int[]{1000000000, 7, 1000000000, 8, 9, 1000000000}, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 3, 1, 1}, 7),
                Arguments.of(new int[]{5, 5, 5, 5}, 3),
                Arguments.of(new int[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 3}, 19),
                Arguments.of(new int[]{1, 7, 6, 2, 3, 5}, 6),
                Arguments.of(new int[]{1, 7, 6, 2, 3, 5, 4}, 6),
                Arguments.of(new int[]{
                        87, 69, 40, 19, 60, 35, 12, 46, 71, 25,
                        69, 77, 37, 32, 51, 7, 94, 31, 15, 22,
                        13, 53, 68, 67, 13, 39, 69, 53, 37, 53,
                        65, 61, 85, 52, 77, 32, 34, 10, 3, 74,
                        95, 27, 5, 3, 14, 72, 48, 50, 29, 99,
                        10, 49, 93, 25, 16, 21, 23, 75, 50, 25,
                        77, 78, 24, 86, 85, 46, 56, 56, 81, 15,
                        2, 94, 81, 41, 78, 8, 40, 10, 81, 72,
                        86, 48, 1, 29, 68, 30, 3, 9, 46, 86,
                        15, 18, 91, 36, 22, 43, 2, 52, 67
                }, 99)
        );
    }

}
