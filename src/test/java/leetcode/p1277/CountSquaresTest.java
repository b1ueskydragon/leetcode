package leetcode.p1277;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountSquaresTest {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCountSquares(int[][] matrix, int expected) {
        assertThat(underTest.countSquares(matrix)).isEqualTo(expected);
    }

    static Stream<Arguments> testCountSquares() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, 15),
                Arguments.of(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}, 7),
                Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 14),
                Arguments.of(new int[][]{{1, 1}, {1, 1}}, 5)
        );
    }
}
