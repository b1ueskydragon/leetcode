package leetcode.p3882;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinCost(int[][] grid, int minXor) {
        assertThat(underTest.minCost(grid)).isEqualTo(minXor);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        1
                ),
                Arguments.of(
                        new int[][]{
                                {6, 7},
                                {5, 8}
                        },
                        9
                ),
                Arguments.of(
                        new int[][]{
                                {731, 42, 918, 305, 0, 567, 1023, 184, 692, 451},
                                {96, 843, 217, 654, 389, 1001, 58, 776, 432, 125}
                        },
                        197
                )
        );
    }

}
