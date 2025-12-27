package leetcode.p1893;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsCoveredTest {

    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[][] ranges, int left, int right, boolean expected) {
        assertThat(v1.isCovered(ranges, left, right)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{7, 11}, {5, 9}, {2, 3}}, 4, 8, false),
                Arguments.of(new int[][]{{1, 10}, {10, 20}}, 21, 21, false),
                Arguments.of(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5, true),
                Arguments.of(new int[][]{{1, 3}, {1, 3}, {1, 3}}, 2, 5, false)
        );
    }
}
