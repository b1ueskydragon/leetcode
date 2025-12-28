package leetcode.p1351;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountNegativesTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[][] ranges, int count) {
        assertThat(v2.countNegatives(ranges)).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[][] ranges, int count) {
        assertThat(v1.countNegatives(ranges)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}, 8),
                Arguments.of(new int[][]{{3, 2}, {1, 0}}, 0),
                Arguments.of(new int[][]{{3, 2, -1, -2}, {2, -1, -2, -3}}, 5),
                Arguments.of(new int[][]{{2}, {1}, {-1}}, 1),
                Arguments.of(new int[][]{{3, 2, -1, -2}, {2, -1, -2, -3}}, 5),
                Arguments.of(new int[][]{{3, 2, -1, -2, -3}, {2, -1, -2, -3, -3}}, 7)
        );
    }
}
