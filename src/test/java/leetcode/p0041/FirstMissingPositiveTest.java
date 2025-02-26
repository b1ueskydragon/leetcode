package leetcode.p0041;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FirstMissingPositiveTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testTheSmallestMissingPositiveNumber(int[] nums, int theSmallestMissingPosNum) {
        assertThat(underTest.firstMissingPositive(nums)).isEqualTo(theSmallestMissingPosNum);
    }

    static Stream<Arguments> testTheSmallestMissingPositiveNumber() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{1, 2, 7, 6, 4, 3}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 7),
                Arguments.of(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, -2147483648}, 9),
                Arguments.of(new int[]{3, 4, -1, 1}, 2),
                Arguments.of(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }
}
