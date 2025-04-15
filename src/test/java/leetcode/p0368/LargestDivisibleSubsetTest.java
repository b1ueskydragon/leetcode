package leetcode.p0368;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LargestDivisibleSubsetTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testLargestDivisibleSubset(int[] nums, List<Integer> theLargest) {
        assertThat(underTest.largestDivisibleSubset(nums)).isEqualTo(theLargest);
    }

    static Stream<Arguments> testLargestDivisibleSubset() {
        return Stream.of(
                // Give an already sorted arrays for better understanding why we need to sort
                Arguments.of(new int[]{2, 3, 10, 20, 30}, List.of(2, 10, 20)),
                Arguments.of(new int[]{2, 3, 10, 20, 33}, List.of(2, 10, 20))
        );
    }
}
