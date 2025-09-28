package leetcode.p0976;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestPerimeterTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLargestPerimeter(int[] nums, int expected) {
        assertThat(underTest.largestPerimeter(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 2}, 5),
                Arguments.of(new int[]{1, 2, 1, 10}, 0),
                Arguments.of(new int[]{1, 2, 2, 5, 6}, 13),
                Arguments.of(new int[]{1, 2, 2, 5, 7}, 5)
        );
    }

}
