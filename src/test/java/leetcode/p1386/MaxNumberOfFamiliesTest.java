package leetcode.p1386;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxNumberOfFamiliesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxNumberOfFamilies(int n, int[][] reservedSeats, int maxAllocation) {
        assertThat(underTest.maxNumberOfFamilies(n, reservedSeats)).isEqualTo(maxAllocation);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        3,
                        new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}},
                        4
                ),
                Arguments.of(
                        2,
                        new int[][]{{2, 1}, {1, 8}, {2, 6}},
                        2
                ),
                Arguments.of(
                        4,
                        new int[][]{{4, 3}, {1, 4}, {4, 6}, {1, 7}},
                        4
                ),
                Arguments.of(
                        100,
                        new int[][]{{50, 5}, {25, 5}, {100, 5}, {4, 5}},
                        196
                ),
                Arguments.of(
                        1_000_000_000,
                        new int[][]{
                                {1, 1},
                                {1_000_000_000, 10},
                                {5000, 4},
                                {100, 3},
                                {777, 2},
                                {1000, 5},
                                {777, 6},
                                {1000, 9},
                                {1000, 1},
                                {1000, 7},
                                {1005, 4}
                        },
                        1_999_999_993
                ),
                Arguments.of(
                        1000,
                        new int[][]{{100, 9}},
                        1999
                ),
                Arguments.of(
                        1_000_000,
                        new int[][]{{100, 1}},
                        2_000_000
                )
        );
    }

}
