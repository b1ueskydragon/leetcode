package leetcode.p3417;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZigzagTraversalTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void zigzagTraversal(int[][] grid, List<Integer> integers) {
        assertThat(underTest.zigzagTraversal(grid)).isEqualTo(integers);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3, 4},
                        {4, 5, 6, 7},
                        {7, 8, 9, 10}
                }, List.of(1, 3, 7, 5, 7, 9)),
                Arguments.of(new int[][]{
                        {1, 2, 3, 4, 5},
                        {4, 5, 6, 7, 8},
                        {7, 8, 9, 10, 11},
                        {1, 2, 3, 4, 5},
                        {4, 5, 6, 7, 8},
                        {7, 8, 9, 10, 11}
                }, List.of(1, 3, 5, 7, 5, 7, 9, 11, 4, 2, 4, 6, 8, 10, 8)),
                Arguments.of(new int[][]{
                        {2, 1},
                        {2, 1},
                        {2, 1}
                }, List.of(2, 1, 2)),
                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, List.of(1, 3, 5, 7, 9))
        );
    }
}
