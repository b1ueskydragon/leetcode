package leetcode.p0739;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DailyTemperaturesTest {

    private SolutionV2 underTestV2;

    @BeforeEach
    void setUp() {
        underTestV2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource
    void testDailyTemperatures(int[] temperatures, int[] result) {
        assertThat(underTestV2.dailyTemperatures(temperatures)).isEqualTo(result);
    }

    static Stream<Arguments> testDailyTemperatures() {
        return Stream.of(
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
                Arguments.of(new int[]{35, 37, 34, 40}, new int[]{1, 2, 1, 0}),
                Arguments.of(new int[]{40, 35, 30}, new int[]{0, 0, 0}),
                Arguments.of(new int[]{35, 37, 34, 36}, new int[]{1, 0, 1, 0})
        );
    }
}
