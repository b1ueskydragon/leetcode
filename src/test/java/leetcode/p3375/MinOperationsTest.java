package leetcode.p3375;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinOperations(int[] nums, int k, int minOp) {
        assertThat(underTest.minOperations(nums, k)).isEqualTo(minOp);
    }

    static Stream<Arguments> testMinOperations() {
        return Stream.of(
                // `nums` includes equivalent number to `k`
                Arguments.of(new int[]{5, 2, 5, 4, 5}, 2, 2),
                // `nums` includes smaller number than `k`
                Arguments.of(new int[]{2, 1, 2}, 2, -1),
                // `k` is smaller than every number in `nums`
                Arguments.of(new int[]{9, 7, 5, 3}, 1, 4)
        );
    }
}
