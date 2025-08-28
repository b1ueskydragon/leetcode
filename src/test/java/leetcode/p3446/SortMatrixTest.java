package leetcode.p3446;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortMatrixTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    // in-place, `matrix` will be modified
    @ParameterizedTest
    @MethodSource("testSource")
    void testSortMatrix(int[][] matrix, int[][] expected) {
        assertThat(underTest.sortMatrix(matrix)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 7, 3},
                                {9, 8, 2},
                                {4, 5, 6}
                        },
                        new int[][]{
                                {8, 2, 3},
                                {9, 6, 7},
                                {4, 5, 1}
                        }
                )
        );
    }

}
