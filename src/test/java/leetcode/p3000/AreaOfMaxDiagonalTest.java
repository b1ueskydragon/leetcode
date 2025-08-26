package leetcode.p3000;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AreaOfMaxDiagonalTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testAreaOfMaxDiagonal(int[][] dimensions, int expected) {
        assertThat(underTest.areaOfMaxDiagonal(dimensions)).isEqualTo(expected);
    }

    static Stream<Arguments> testAreaOfMaxDiagonal() {
        return Stream.of(
                Arguments.of(new int[][]{{25, 60}, {39, 52}, {33, 56}, {16, 63}}, 2028),
                Arguments.of(new int[][]{{8, 6}, {2, 10}}, 20)
        );
    }

}
