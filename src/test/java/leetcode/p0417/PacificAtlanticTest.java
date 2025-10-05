package leetcode.p0417;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PacificAtlanticTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPacificAtlantic(int[][] heights, List<List<Integer>> expected) {
        assertThat(underTest.pacificAtlantic(heights)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}
                }, List.of(
                        List.of(0, 4),
                        List.of(1, 3),
                        List.of(1, 4),
                        List.of(2, 2),
                        List.of(3, 0),
                        List.of(3, 1),
                        List.of(4, 0)
                )),
                Arguments.of(new int[][]{
                        {1},
                }, List.of(
                        List.of(0, 0)
                )),
                Arguments.of(new int[][]{
                        {6, 7, 1},
                        {5, 1, 1}
                }, List.of(
                        List.of(0, 0),
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(1, 0),
                        List.of(1, 1),
                        List.of(1, 2)
                ))
        );
    }

}
