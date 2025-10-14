package leetcode.p3349;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HasIncreasingSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testHasIncreasingSubarrays(List<Integer> nums, int k, boolean expected) {
        assertThat(underTest.hasIncreasingSubarrays(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3, true),
                Arguments.of(List.of(1, 2, 3, -1), 2, false),
                Arguments.of(List.of(-15, -13, 4, 7), 2, true),
                Arguments.of(List.of(15, -15, -13, 4), 2, false),
                Arguments.of(List.of(-263, 849, 567, -39, -618, 414, -955, -538, -890, 381, 887, 9, -442, 322, 592, -92, 264, -98, -69, 748, -787, -263, 468, -24, 869, 672, -365, -51, 973, 502, -296, 895, 541, 895, -598, 927, -171, -453, 365, 230, 345, 387, 983, -368, 121, -225, 617, 204, -998, -951, -663, -664, 853, 490, -233, -661, -757, -405, -854, -428, 9, -526, 729, 965, -617, -891, 85, -944, 541, 60, -786, 648, -250, 33, -430, -214, 566, -379, -113, 204, -866, -801, -831, -805, 388, -413, 301, -245, 309, 176, 851, 330, -301, 483, -27, -791, -647, -959), 2, true)
        );
    }

}
