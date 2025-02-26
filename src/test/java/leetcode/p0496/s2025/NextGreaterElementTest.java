package leetcode.p0496.s2025;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class NextGreaterElementTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testNextGreaterElement(int[] nums1, int[] nums2, int[] nextGreaterElements) {
        assertThat(underTest.nextGreaterElement(nums1, nums2)).isEqualTo(nextGreaterElements);
    }

    static Stream<Arguments> testNextGreaterElement() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                Arguments.of(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1}),
                Arguments.of(new int[]{3, 1, 2, 5}, new int[]{3, 1, 2, 5}, new int[]{5, 2, 5, -1}),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10, 1, 5, 3, 9, 7}, new int[]{5, 9, 9, -1, -1})
        );
    }
}
