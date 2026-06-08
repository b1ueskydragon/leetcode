package leetcode.p2161;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PivotArrayTest {

    private Solution s2025;
    private Solution s2026;

    @BeforeEach
    void setUp() {
        s2025 = new Solution2025();
        s2026 = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2025(int[] nums, int pivot, int[] rearranged) {
        assertThat(s2025.pivotArray(nums, pivot)).isEqualTo(rearranged);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2026(int[] nums, int pivot, int[] rearranged) {
        assertThat(s2026.pivotArray(nums, pivot)).isEqualTo(rearranged);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{9, 12, 5, 10, 14, 3, 10}, 10, new int[]{9, 5, 3, 10, 10, 12, 14}),
                Arguments.of(new int[]{-3, 4, 3, 2}, 2, new int[]{-3, 2, 4, 3}),
                Arguments.of(new int[]{9, 12, 5, 10, 14, 3, 10}, 3, new int[]{3, 9, 12, 5, 10, 14, 10}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1}, 1, new int[]{1, 1, 1, 1, 1, 1})
        );
    }
}
