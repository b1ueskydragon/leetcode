package leetcode.p3742;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPathScoreTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxPathScore(int[][] grid, int k) {
        assertThat(underTest.maxPathScore(grid, k));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 1, 2},
                                {0, 1, 2}},
                        4,
                        5
                ),
                Arguments.of(
                        new int[][]{
                                {0, 1},
                                {2, 0}},
                        1,
                        2
                ),
                Arguments.of(
                        new int[][]{
                                {0, 1},
                                {1, 2}},
                        1,
                        -1
                )
        );
    }
}
