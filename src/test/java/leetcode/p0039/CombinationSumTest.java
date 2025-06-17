package leetcode.p0039;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCombinationSum(int[] candidates, int target, List<List<Integer>> combinations) {
        assertThat(underTest.combinationSum(candidates, target)).isEqualTo(combinations);
    }

    static Stream<Arguments> testCombinationSum() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7)))
        );
    }

}
