package leetcode.p2144;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCostTest {

    private Solution v2;
    private Solution v1;

    @BeforeEach
    void setUp() {
        v2 = new SolutionV2();
        v1 = new SolutionV1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] cost, int minCost) {
        assertThat(v2.minimumCost(cost)).isEqualTo(minCost);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] cost, int minCost) {
        assertThat(v1.minimumCost(cost)).isEqualTo(minCost);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 5),
                Arguments.of(new int[]{6, 5, 7, 9, 2, 2}, 23),
                Arguments.of(new int[]{5, 5}, 10),
                Arguments.of(new int[]{2, 3, 4}, 7),
                Arguments.of(new int[]{1, 80, 11, 21, 12, 21, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 100, 99, 98, 80, 44, 55, 54, 56}, 624),
                Arguments.of(new int[]{98, 98, 98, 98, 98}, 392),
                Arguments.of(new int[]{98, 98, 98, 98}, 294),
                Arguments.of(new int[]{3, 3, 3, 1}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7, 8, 8, 9, 9, 9, 9, 9}, 59),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7, 8, 8, 8, 9, 9, 9, 9}, 58),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7, 7, 7, 8, 9, 9, 9, 9}, 57)
        );
    }

}
