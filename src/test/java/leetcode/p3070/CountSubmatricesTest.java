package leetcode.p3070;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountSubmatricesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCountSubmatrices(int[][] grid, int k, int count) {
        assertThat(underTest.countSubmatrices(grid, k)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}},
                        20,
                        6
                ),
                Arguments.of(
                        new int[][]{{7, 6, 3}, {6, 6, 1}},
                        18,
                        4
                )
        );
    }

}
