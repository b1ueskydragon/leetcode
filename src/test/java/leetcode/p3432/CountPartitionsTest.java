package leetcode.p3432;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountPartitionsTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] nums, int count) {
        assertThat(v1.countPartitions(nums)).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] nums, int count) {
        assertThat(v1.countPartitions(nums)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{10, 10, 3, 7, 6}, 4),
                Arguments.of(new int[]{1, 2, 2}, 0),
                Arguments.of(new int[]{2, 4, 6, 8}, 3),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{2, 2}, 1),
                Arguments.of(new int[]{1, 2}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100}, 99)
        );
    }

}
