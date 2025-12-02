package leetcode.p3364;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSumSubarrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumSumSubarray(List<Integer> nums, int l, int r, int expected) {
        assertThat(underTest.minimumSumSubarray(nums, l, r)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(-1, 2, 3, -4, 5, 6), 3, 5, 1),
                Arguments.of(List.of(2, 1, -8, 8, -1, -7, 9, -5, -8, 0), 1, 10, 1),
                Arguments.of(List.of(653, -629, -935, -479, 560, -355, 237, -346, 175, 926, -371, 43, -759, -361, -445, -479, -623, -468, -584, 383, -43, 248, -82, 333, 533, 425, 598, -750, 779, -952, -73, -80, -507, 683, 182, -155, 913, -418, 86, 387, -934, -937, 554, -797, -6, 487, -97, -782, 304, -474, 281, -921, -155, 124, -363, 493, 202, 650, 225, 994, 990, 901, 751, 107, 981, 197, -802, -70, 234, -689, -800, -928, -976, 207, 689, -555, 677, -803, 310, 260, 879, -779, -36, 167, 916, -334, -311, -126, -547, -197, -78, -497, 550, 28, -226, 557, 994, 148, -798, -850), 20, 80, 1)
        );
    }
}
