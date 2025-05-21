package leetcode.p3024;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTypeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testTriangleType(int[] nums, String result) {
        assertThat(underTest.triangleType(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testTriangleType() {
        return Stream.of(
                Arguments.of(new int[]{6, 6, 10}, "isosceles"),
                Arguments.of(new int[]{1, 1, 10}, "none"),
                Arguments.of(new int[]{3, 3, 3}, "equilateral"),
                Arguments.of(new int[]{3, 4, 5}, "scalene")
        );
    }
}
