package leetcode.p0743;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NetworkDelayTimeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void networkDelayTime(int[][] times, int n, int k, int expected) {
        assertThat(underTest.networkDelayTime(times, n, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 3}, {2, 3, 1}, {3, 4, 4}}, 4, 2, 5),
                Arguments.of(new int[][]{{1, 2, 1}}, 2, 1, 1),
                Arguments.of(new int[][]{{1, 2, 2}, {2, 3, 49}, {1, 3, 50}}, 3, 1, 50),
                Arguments.of(new int[][]{{2, 1, 10}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 10),
                Arguments.of(new int[][]{{2, 3, 1}}, 3, 2, -1)
        );
    }

}
