package leetcode.p0416.s2025;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CanPartitionTest {

    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource
    void testCanPartition(int[] nums, boolean result) {
        assertThat(v1.canPartition(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testCanPartition() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 4, 3}, true),
                Arguments.of(new int[]{1, 2, 3, 5}, false),
                Arguments.of(new int[]{
                        88, 92, 29, 83, 13, 86, 95, 61, 11, 74, 60,
                        53, 39, 33, 18, 91, 61, 24, 64, 14, 4, 47, 17,
                        53, 35, 81, 65, 80, 65, 86, 46, 79, 99, 45, 27,
                        67, 66, 93, 98, 59, 20, 47, 46, 12, 95, 73, 37,
                        72, 21, 54, 72, 64, 18, 75, 33, 91, 82, 70, 89,
                        81, 79, 12, 73, 59, 83, 48, 66, 53, 14, 65, 26,
                        66, 15, 37, 92, 56, 27, 61, 64, 83, 15, 41, 17,
                        70, 45, 31, 98, 72, 58, 95, 93, 37, 61, 94, 37,
                        96, 37, 5, 74, 26}, true),
                Arguments.of(new int[]{
                        100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100}, true)
        );
    }
}
