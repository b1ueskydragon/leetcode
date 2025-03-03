package leetcode.p2161;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PivotArrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testPivotArray(int[] nums, int pivot, int[] rearranged) {
        assertThat(underTest.pivotArray(nums, pivot)).isEqualTo(rearranged);
    }

    static Stream<Arguments> testPivotArray() {
        return Stream.of(
                Arguments.of(new int[]{9, 12, 5, 10, 14, 3, 10}, 10, new int[]{9, 5, 3, 10, 10, 12, 14}),
                Arguments.of(new int[]{-3, 4, 3, 2}, 2, new int[]{-3, 2, 4, 3}),
                Arguments.of(new int[]{9, 12, 5, 10, 14, 3, 10}, 3, new int[]{3, 9, 12, 5, 10, 14, 10})
        );
    }
}
