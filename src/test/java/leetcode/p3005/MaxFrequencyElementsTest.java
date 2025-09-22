package leetcode.p3005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxFrequencyElementsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxFrequencyElements(int[] nums, int expected) {
        assertThat(underTest.maxFrequencyElements(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{99, 92, 99, 100, 100, 99, 97, 99, 98, 92, 99, 92, 92, 90, 97, 90, 100, 91, 100, 93, 97, 99, 95, 97, 93, 95, 95, 97, 94, 92, 97, 100, 98, 95, 99, 90, 94, 94, 90, 96, 92, 96, 96, 98, 100, 91, 92, 91, 91, 97, 92, 90, 90, 99, 99, 90, 98, 98, 90, 93, 92, 100, 95, 94, 95, 90, 91, 99, 92, 96, 98, 91, 94, 95, 91, 100, 96, 98, 93, 92, 91, 96, 93, 90, 99, 93, 95, 98, 93, 99, 91, 98, 100, 92, 94, 96, 90, 93, 99, 91},
                        13
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        100
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        5
                ),
                Arguments.of(
                        new int[]{100},
                        1
                )
        );
    }

}
