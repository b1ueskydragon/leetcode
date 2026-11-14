package leetcode.p3364;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSumSubarrayTest {

    private Solution2025 s2025;
    private Solution2026 s2026;

    @BeforeEach
    void setUp() {
        s2025 = new Solution2025();
        s2026 = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2025(List<Integer> nums, int l, int r, int expected) {
        assertThat(s2025.minimumSumSubarray(nums, l, r)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void test2026(List<Integer> nums, int l, int r, int expected) {
        assertThat(s2026.minimumSumSubarray(nums, l, r)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(-1, 2, 3, -4, 5, 6), 3, 5, 1),
                Arguments.of(List.of(2, 1, -8, 8, -1, -7, 9, -5, -8, 0), 1, 10, 1),
                Arguments.of(List.of(653, -629, -935, -479, 560, -355, 237, -346, 175, 926, -371, 43, -759, -361, -445, -479, -623, -468, -584, 383, -43, 248, -82, 333, 533, 425, 598, -750, 779, -952, -73, -80, -507, 683, 182, -155, 913, -418, 86, 387, -934, -937, 554, -797, -6, 487, -97, -782, 304, -474, 281, -921, -155, 124, -363, 493, 202, 650, 225, 994, 990, 901, 751, 107, 981, 197, -802, -70, 234, -689, -800, -928, -976, 207, 689, -555, 677, -803, 310, 260, 879, -779, -36, 167, 916, -334, -311, -126, -547, -197, -78, -497, 550, 28, -226, 557, 994, 148, -798, -850), 20, 80, 1),
                Arguments.of(List.of(-2, 2, -3, 1), 2, 3, -1),
                Arguments.of(List.of(-790, -897, 355, -964, 731, 598, -643, -426, -842, 944, 765, 992, -433, 422, -652, -672, 369, 575, -562, -36, 449, 710, -615, -762, 913, 567, -398, 3, -672, 388, -833, 500, 717, 117, -332, 488, -859, -219, 85, 217, -962, -687, -609, -527, -643, -29, -514, -532, -259, -278, -488, -115, -4, -551, -105, -328, -589, -509, -21, -20, -909, -924, -494, -698, -346, -989, -380, -242, -860, -333, -508, -34, -213, -934, -451, -672, -69, -564, -90, -671, -216, -491, -576, -240, -701, -251, -61, -373, -996, -902, -322, -201, 719, 180, 248, -392, 553, 68, -908), 37, 69, 23),
                Arguments.of(List.of(672, -68, 901, 785, -841, -71, 805, -320, 844, -899, -217, -249, -89, 467, 768, -711, 9, 754, 198, 29, -966, -228, -390, 944, 892, 956, -72, 723, 549, 219, -4, 780, 622, 542, -436, -964, -572, 96, -105, -356, 155, -483, 474, 222, -935, -567, -812, 127, -496, -667, 715, -119, -640, 571, -489, -741, -712, 278, 234, 391, -843, 784, 129, -469, 741, -59, 496, 11, -674, 964, 34, -265, -929, 484, -432, -876, -642, -277, -133, -778, -458, -678), 3, 6, 12)
        );
    }
}
