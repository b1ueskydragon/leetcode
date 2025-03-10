package leetcode.p0011;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxAreaTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaxArea(int[] height, int maxArea) {
        assertThat(underTest.maxArea(height)).isEqualTo(maxArea);
    }

    static Stream<Arguments> testMaxArea() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 8, 100, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 8, 6, 2, 100, 100, 8, 3, 7}, 100),
                Arguments.of(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8}, 64),
                Arguments.of(new int[]{9, 8, 8, 8, 8, 8, 8, 8, 8}, 64),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 20),
                Arguments.of(new int[]{1, 2}, 1)
        );
    }
}
