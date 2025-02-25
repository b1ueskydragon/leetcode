package leetcode.p1615;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximalNetworkRankTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaximalNetworkRank(int n, int[][] roads, int maximalNetworkRank) {
        assertThat(underTest.maximalNetworkRank(n, roads)).isEqualTo(maximalNetworkRank);
    }

    static Stream<Arguments> testMaximalNetworkRank() {
        return Stream.of(
                // super node (一番友達が多い node, 次に友達が多い node) 同士が繋がっているケース
                Arguments.of(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}, 4),
                Arguments.of(5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}, 5),
                // super node (一番友達が多い node, 次に友達が多い node) 同士が繋がっていないケース
                Arguments.of(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}, 5)
        );
    }
}
