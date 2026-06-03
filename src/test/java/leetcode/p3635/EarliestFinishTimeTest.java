package leetcode.p3635;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EarliestFinishTimeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testEarliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration,
            int bestMin
    ) {
        assertThat(underTest.earliestFinishTime(
                landStartTime, landDuration, waterStartTime, waterDuration)).isEqualTo(bestMin);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 4, 1, 100, 99, 22, 33, 44, 10, 2},
                        new int[]{1, 6, 44, 3, 100, 99, 11, 22, 8, 100},
                        new int[]{2, 33, 44, 10, 2, 9, 11},
                        new int[]{99, 11, 22, 8, 100, 12, 4},
                        15
                ),
                Arguments.of(
                        new int[]{2, 8},
                        new int[]{4, 1},
                        new int[]{6},
                        new int[]{3},
                        9
                ),
                // A test case related to checking swap given parameters.
                Arguments.of(
                        new int[]{5},
                        new int[]{3},
                        new int[]{1},
                        new int[]{10},
                        14
                ),
                // Test cases related to checking if (i > -1) and if (i < m - 1) after the binarySearch.
                Arguments.of(
                        new int[]{63, 11, 6},
                        new int[]{30, 99, 1},
                        new int[]{69, 38},
                        new int[]{83, 45},
                        83
                ),
                Arguments.of(
                        new int[]{742, 115, 893},
                        new int[]{45, 912, 334},
                        new int[]{221, 650},
                        new int[]{104, 789},
                        787
                )
        );
    }

}
