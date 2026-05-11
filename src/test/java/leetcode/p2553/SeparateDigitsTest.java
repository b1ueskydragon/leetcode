package leetcode.p2553;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SeparateDigitsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSeparateDigits(int[] nums, int[] expected) {
        assertThat(underTest.separateDigits(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{13, 25, 83, 77}, new int[]{1, 3, 2, 5, 8, 3, 7, 7}),
                Arguments.of(new int[]{7, 1, 3, 9}, new int[]{7, 1, 3, 9}),
                Arguments.of(
                        new int[]{100000, 1000, 100, 10, 1, 9, 999, 9, 999, 9, 999, 9, 9, 9, 999, 9, 9, 999, 9, 9999},
                        new int[]{
                                1, 0, 0, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0,
                                1, 0,
                                1,
                                9,
                                9, 9, 9,
                                9,
                                9, 9, 9,
                                9,
                                9, 9, 9,
                                9,
                                9,
                                9,
                                9, 9, 9,
                                9,
                                9,
                                9, 9, 9,
                                9,
                                9, 9, 9, 9
                        }
                ),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{100000}, new int[]{1, 0, 0, 0, 0, 0})
        );
    }
}
