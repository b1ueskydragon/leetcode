package leetcode.p0046.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermuteTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPermute(int[] nums, List<List<Integer>> permutations) {
        assertThat(underTest.permute(nums)).isEqualTo(permutations);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))
                ),
                Arguments.of(
                        new int[]{-10, 10},
                        List.of(List.of(-10, 10), List.of(10, -10))
                ),
                Arguments.of(
                        new int[]{0},
                        List.of(List.of(0))
                )
        );
    }
}
