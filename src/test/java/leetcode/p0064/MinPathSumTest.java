package leetcode.p0064;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinPathSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinPathSum(int[][] grid, int minPathSum) {
        assertThat(underTest.minPathSum(grid)).isEqualTo(minPathSum);
    }

    static Stream<Arguments> testMinPathSum() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}, 7),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}}, 12)
        );
    }

}
