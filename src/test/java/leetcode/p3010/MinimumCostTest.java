package leetcode.p3010;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCostTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumCost(int[] nums, int expected) {
        assertThat(underTest.minimumCost(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 12}, 6),
                Arguments.of(new int[]{5, 4, 3}, 12),
                Arguments.of(new int[]{10, 3, 1, 1}, 12),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 13),
                Arguments.of(new int[]{3, 5, 7, 9, 11, 1, 7, 6, 5}, 9),
                Arguments.of(new int[]{37, 36, 13, 22, 5, 41, 16, 13, 8, 18, 13, 37, 44, 46, 1, 27, 47, 49, 25, 28, 9, 4, 15, 46, 6, 14, 29, 26, 44, 29, 31, 3, 36, 48, 36, 7, 36, 36, 38, 43, 15, 14, 45, 16, 31, 1, 11, 43, 10, 2}, 39),
                Arguments.of(new int[]{1, 1, 1}, 3)
        );
    }

}
