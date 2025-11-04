package leetcode.p3318;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindXSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindXSum(int[] nums, int k, int x, int[] expected) {
        assertThat(underTest.findXSum(nums, k, x)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2, new int[]{6, 10, 12}),
                Arguments.of(new int[]{3, 8, 7, 8, 7, 5}, 2, 2, new int[]{11, 15, 15, 15, 12}),
                Arguments.of(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 1, 1, new int[]{1, 1, 2, 2, 3, 4, 2, 3})
        );
    }
}
