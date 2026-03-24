package leetcode.p2906;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructProductMatrixTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void constructProductMatrix(int[][] grid, int[][] expected) {
        assertThat(underTest.constructProductMatrix(grid)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {4, 2, 3},
                                {3, 1, 2},
                                {2, 4, 1}
                        },
                        new int[][]{
                                {288, 576, 384},
                                {384, 1152, 576},
                                {576, 288, 1152}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1000000000, 999999999, 1000000000, 999999998},
                                {999999999, 999999999, 1000000000, 1000000000},
                                {1000000000, 999999999, 999999998, 1000000000}
                        },
                        new int[][]{
                                {5190, 285, 5190, 6585},
                                {285, 285, 5190, 5190},
                                {5190, 285, 6585, 5190}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {12345},
                                {2},
                                {1}
                        },
                        new int[][]{
                                {2},
                                {0},
                                {0}
                        }
                )
        );
    }
}
