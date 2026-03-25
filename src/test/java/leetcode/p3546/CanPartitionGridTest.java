package leetcode.p3546;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CanPartitionGridTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testCanPartitionGrid(int[][] grid, boolean expected) {
        assertThat(underTest.canPartitionGrid(grid)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(
                new int[][]{
                    {3, 2, 1},
                    {2, 1, 2},
                    {3, 1, 1}
                },
                true
            ),
            Arguments.of(
                new int[][]{
                    {1, 4},
                    {2, 3}
                },
                true
            ),
            Arguments.of(
                new int[][]{
                    {1, 3},
                    {2, 4}
                },
                false
            ),
            Arguments.of(
                new int[][]{
                    {5},
                    {5}
                },
                true
            ),
            Arguments.of(
                new int[][]{
                    {5},
                    {4}
                },
                false
            )
        );
    }

}
