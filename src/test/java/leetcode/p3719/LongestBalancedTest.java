package leetcode.p3719;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestBalancedTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLongestBalanced(int[] nums, int expected) {
        assertThat(underTest.longestBalanced(nums)).isEqualTo(expected);
    }


    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 5, 4}, 5),
                Arguments.of(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 2}, 9),
                Arguments.of(new int[]{3, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2}, 19)
        );
    }

}
