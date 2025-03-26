package leetcode.p2033;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinOperations(int[][] grid, int x, int minOperations) {
        assertThat(underTest.minOperations(grid, x)).isEqualTo(minOperations);
    }

    static Stream<Arguments> testMinOperations() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 4}, {6, 8}}, 2, 4),
                Arguments.of(new int[][]{{1, 5}, {2, 3}}, 1, 5),
                Arguments.of(new int[][]{{1, 1, 1, 1, 100}, {1, 2, 3, 4, 5}}, 1, 109)
        );
    }
}
