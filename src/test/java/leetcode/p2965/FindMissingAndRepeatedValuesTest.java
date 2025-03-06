package leetcode.p2965;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindMissingAndRepeatedValuesTest {

    private Solution underTest;
    private SolutionV2 underTestV2;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
        underTestV2 = new SolutionV2();
    }

    // All solution instances won't modify given `grid` directly
    @ParameterizedTest
    @MethodSource
    void testFindMissingAndRepeatedValues(int[][] grid, int[] repeatingAndMissing) {
        assertThat(underTest.findMissingAndRepeatedValues(grid)).isEqualTo(repeatingAndMissing);
        assertThat(underTestV2.findMissingAndRepeatedValues(grid)).isEqualTo(repeatingAndMissing);
    }

    static Stream<Arguments> testFindMissingAndRepeatedValues() {
        return Stream.of(
                Arguments.of(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 5}}, new int[]{9, 6}),
                Arguments.of(new int[][]{{8, 1, 7}, {8, 9, 2}, {3, 4, 6}}, new int[]{8, 5}),
                Arguments.of(new int[][]{{1, 3}, {2, 2}}, new int[]{2, 4})
        );
    }
}
