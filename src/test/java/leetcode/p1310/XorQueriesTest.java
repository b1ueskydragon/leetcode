package leetcode.p1310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class XorQueriesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testXorQueries(int[] arr, int[][] queries, int[] answer) {
        assertThat(underTest.xorQueries(arr, queries)).isEqualTo(answer);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}}, new int[]{2, 7, 14, 8}),
                Arguments.of(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}}, new int[]{8, 0, 4, 4}),
                Arguments.of(new int[]{1, 1000000000, 2, 999999999, 3, 999999998, 4, 999999997, 5, 1000000000}, new int[][]{{0, 9}, {1, 8}, {2, 7}, {3, 6}, {4, 9}}, new int[]{999999997, 1020, 999999993, 6, 1000000001})
        );
    }
}
