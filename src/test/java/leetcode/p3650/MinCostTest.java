package leetcode.p3650;

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
    void testMinCost(int n, int[][] edges, int minCost) {
        assertThat(underTest.minCost(n, edges)).isEqualTo(minCost);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(4, new int[][]{{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}}, 5),
                Arguments.of(2, new int[][]{{0, 0, 1}, {1, 1, 1}}, -1)
        );
    }
}
