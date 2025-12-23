package leetcode.p2054;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTwoEventsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxTwoEvents(int[][] events, int maxSum) {
        assertThat(underTest.maxTwoEvents(events)).isEqualTo(maxSum);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 2}, {3, 5, 4}, {3, 8, 1}, {6, 7, 6}, {9, 10, 3}}, 10),
                Arguments.of(new int[][]{{91, 100, 42}, {92, 100, 22}, {1, 77, 50}, {66, 97, 90}, {98, 98, 68}, {38, 49, 63}, {64, 72, 97}}, 165),
                Arguments.of(new int[][]{{1, 2, 2}, {1, 2, 2}, {1, 1, 2}, {1, 2, 1}, {2, 2, 1}, {2, 2, 1}, {2, 2, 2}}, 4),
                Arguments.of(new int[][]{{1, 3, 2}, {4, 5, 2}, {1, 5, 5}}, 5)
        );
    }
}
