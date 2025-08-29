package leetcode.p3446;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortMatrixTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    // in-place, `matrix` will be modified
    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[][] matrix, int[][] expected) {
        assertThat(v2.sortMatrix(matrix)).isEqualTo(expected);
    }

    // in-place, `matrix` will be modified
    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[][] matrix, int[][] expected) {
        assertThat(v1.sortMatrix(matrix)).isEqualTo(expected);
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
