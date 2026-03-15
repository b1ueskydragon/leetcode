package leetcode.p0047.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermuteUniqueTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPermuteUnique(int[] nums, List<List<Integer>> uniquePermutations) {
        assertThat(underTest.permuteUnique(nums)).isEqualTo(uniquePermutations);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 1, 2},
                        List.of(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1))
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))
                ),
                Arguments.of(
                        new int[]{1, 1, 2, 1},
                        List.of(List.of(1, 1, 1, 2), List.of(1, 1, 2, 1), List.of(1, 2, 1, 1), List.of(2, 1, 1, 1))
                )
        );
    }

}
