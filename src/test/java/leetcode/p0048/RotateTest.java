package leetcode.p0048;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testRotate(int[][] matrix, int[][] rotated) {
        underTest.rotate(matrix);
        assertThat(matrix).isEqualTo(rotated);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20},
                                {21, 22, 23, 24, 25}
                        },
                        new int[][]{
                                {21, 16, 11, 6, 1},
                                {22, 17, 12, 7, 2},
                                {23, 18, 13, 8, 3},
                                {24, 19, 14, 9, 4},
                                {25, 20, 15, 10, 5}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {5, 1, 9, 11},
                                {2, 4, 8, 10},
                                {13, 3, 6, 7},
                                {15, 14, 12, 16}
                        },
                        new int[][]{
                                {15, 13, 2, 5},
                                {14, 3, 4, 1},
                                {12, 6, 8, 9},
                                {16, 7, 10, 11}
                        }
                )
        );
    }

}
