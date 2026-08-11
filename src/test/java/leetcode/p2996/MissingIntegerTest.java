package leetcode.p2996;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingIntegerTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMissingInteger(int[] nums, int expected) {
        assertThat(underTest.missingInteger(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 5}, 6),
                Arguments.of(new int[]{3, 4, 5, 1, 12, 14, 13}, 15),
                Arguments.of(new int[]{3, 4, 5, 6, 7, 25, 1, 2, 3, 4, 5}, 26),
                Arguments.of(new int[]{1, 3, 4, 5, 6, 7}, 2),
                Arguments.of(new int[]{11, 12, 13, 14, 50}, 51),
                Arguments.of(new int[]{29, 30, 31, 32, 33, 34, 35, 36, 37}, 297),
                Arguments.of(new int[]{
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                        41, 42, 43, 44, 45, 46, 47, 48, 49, 50
                }, 1275)
        );
    }

}
