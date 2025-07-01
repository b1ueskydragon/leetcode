package leetcode.p2099;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubsequenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testFindKthLargest(int[] nums, int k, int[] subSeq) {
        assertThat(underTest.maxSubsequence(nums, k)).isEqualTo(subSeq);
    }

    static Stream<Arguments> testFindKthLargest() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 3}, 2, new int[]{3, 3}),
                Arguments.of(new int[]{-1, -2, 3, 4}, 3, new int[]{-1, 3, 4}),
                Arguments.of(new int[]{3, 4, 3, 3}, 2, new int[]{4, 3}),
                Arguments.of(new int[]{-56, -214, -345, 952, 529, -294, -325, -924, -27, -41, 716, -67, -65, -481}, 3, new int[]{952, 529, 716})
        );
    }
}
