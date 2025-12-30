package leetcode.p0840;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumMagicSquaresInsideTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNumMagicSquaresInside(int[][] grid, int count) {
        assertThat(underTest.numMagicSquaresInside(grid)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}, 1),
                Arguments.of(new int[][]{{8}}, 0),
                Arguments.of(new int[][]{{4, 3, 8, 4, 3, 8, 4, 3, 8}, {9, 5, 1, 9, 5, 1, 9, 5, 1}, {2, 7, 6, 2, 7, 6, 2, 7, 6}, {8, 1, 6, 4, 3, 8, 4, 3, 8}, {3, 7, 9, 2, 8, 1, 9, 5, 1}, {4, 3, 8, 1, 6, 7, 2, 7, 6}, {9, 5, 1, 7, 8, 9, 8, 1, 6}, {2, 7, 6, 4, 9, 1, 3, 7, 9}, {8, 1, 6, 4, 3, 8, 4, 3, 8}, {3, 7, 9, 2, 8, 1, 9, 5, 1}}, 5),
                Arguments.of(new int[][]{{4, 3, 8, 4, 3}, {9, 5, 1, 9, 5}, {2, 7, 6, 2, 7}}, 1),
                Arguments.of(new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}}, 0)
        );
    }
}
