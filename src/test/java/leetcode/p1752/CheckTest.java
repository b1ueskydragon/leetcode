package leetcode.p1752;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCheck(int[] nums, boolean expected) {
        assertThat(underTest.check(nums)).isEqualTo(expected);
    }


    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 1, 2}, true),
                Arguments.of(new int[]{2, 1, 3, 4}, false),
                Arguments.of(new int[]{1, 2, 3}, true),
                Arguments.of(new int[]{1, 1, 1}, true),
                Arguments.of(new int[]{6, 10, 6}, true),
                Arguments.of(new int[]{7, 9, 1, 1, 1, 3}, true),
                Arguments.of(new int[]{2, 1}, true)
        );
    }

}
