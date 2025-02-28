package leetcode.p0994;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrangesRottingTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testOrangesRotting(int[][] grid, int theMinTime) {
        assertThat(underTest.orangesRotting(grid)).isEqualTo(theMinTime);
    }

    static Stream<Arguments> testOrangesRotting() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1}}, -1),
                Arguments.of(new int[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}}, 0),
                Arguments.of(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
                // こういうケースって visited つけながら愚直に (0,0) から探索すると (0,0) に戻って来れない
                // visited つけずに brute force っぽくすると TLE になる... の矛盾が発生する
                // だから「どこを最初に queue に入れるか」が重要
                Arguments.of(new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}}, 2)
        );
    }
}
