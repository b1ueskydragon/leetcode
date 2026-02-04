package leetcode.p3637;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsTrionicTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testIsTrionic(int[] nums, boolean expected) {
        assertThat(underTest.isTrionic(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 4, 2, 6}, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, false),
                Arguments.of(new int[]{1, 2, 1, 2}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 5, 4, 5, 5, 4, 3, 5, 6}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
                Arguments.of(new int[]{1, 3, 1}, false),
                Arguments.of(new int[]{6, 7, 5, 1}, false)
        );
    }
}
