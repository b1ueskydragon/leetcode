package leetcode.p0684;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindRedundantConnectionTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindRedundantConnection(int[][] edges, int[] redundantEdge) {
        assertThat(underTest.findRedundantConnection(edges)).isEqualTo(redundantEdge);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2},
                                {1, 3},
                                {2, 3} // this
                        },
                        new int[]{2, 3}
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2},
                                {1, 3},
                                {3, 4},
                                {1, 4}, // this
                                {1, 5}
                        },
                        new int[]{1, 4}
                )
        );
    }

}
