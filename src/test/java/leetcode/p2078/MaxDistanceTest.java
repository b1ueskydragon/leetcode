package leetcode.p2078;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistanceTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] colors, int best) {
        assertThat(v1.maxDistance(colors)).isEqualTo(best);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] colors, int best) {
        assertThat(v2.maxDistance(colors)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 3, 8, 3, 1}, 4),
                Arguments.of(new int[]{4, 4, 4, 11, 4, 4, 11, 4, 4, 4, 4, 4}, 8),
                Arguments.of(new int[]{1, 8, 3, 8, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 1, 3, 1, 3, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3, 1}, 35)
        );
    }

}
