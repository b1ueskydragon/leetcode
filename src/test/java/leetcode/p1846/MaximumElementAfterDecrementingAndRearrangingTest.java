package leetcode.p1846;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumElementAfterDecrementingAndRearrangingTest {

    private Solution v2;
    private Solution v1;

    @BeforeEach
    void setUp() {
        v2 = new SolutionV2();
        v1 = new SolutionV1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] arr, int max) {
        assertThat(v2.maximumElementAfterDecrementingAndRearranging(arr)).isEqualTo(max);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] arr, int max) {
        assertThat(v1.maximumElementAfterDecrementingAndRearranging(arr)).isEqualTo(max);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1, 2, 1}, 2),
                Arguments.of(new int[]{2, 2, 3, 4, 4, 5, 7, 10, 11, 13}, 9),
                Arguments.of(new int[]{1, 50, 50, 50, 100, 100}, 6),
                Arguments.of(new int[]{1000000}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{2, 2, 3, 6}, 4),
                Arguments.of(new int[]{100, 1, 1000}, 3),
                Arguments.of(new int[]{
                        30, 71, 28, 54, 13, 54, 43, 72, 85, 79, 49, 82, 56, 30, 5, 52, 46,
                        15, 77, 61, 53, 82, 33, 38, 24, 29, 65, 15, 98, 99, 67, 6, 47, 71,
                        75, 57, 33, 3, 63, 36, 91, 63, 75, 48, 11, 81, 46, 57, 7, 13, 55,
                        63, 15, 3, 36, 95, 8, 45, 66, 92, 65, 2, 96, 2, 90, 98, 66, 8, 100,
                        28, 48, 18, 38, 72, 79, 54, 22, 86, 90, 83, 38, 7, 84, 86, 65, 14,
                        3, 35, 12, 87, 4, 54, 81, 92, 65, 93, 69, 100, 38
                }, 94)
        );
    }

}
