package leetcode.p0874;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RobotSimTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testRobotSim(int[] commands, int[][] obstacles, int best) {
        assertThat(underTest.robotSim(commands, obstacles)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{6, -1, -1, 6},
                        new int[][]{{0, 0}},
                        36
                ),
                Arguments.of(
                        new int[]{4, -1, 4, -2, 4},
                        new int[][]{{2, 4}},
                        65
                ),
                Arguments.of(
                        new int[]{9, -1, 9, 9, -2, 9, 9, -1, 9, 9, -2, 9, 9, 9, -1, 9, 9, -2, 9, 9, -1, -1, 9, 9},
                        new int[][]{{10, 10}, {5, 5}, {8, 8}, {15, 15}, {20, 20}},
                        8100
                )
        );
    }

}
