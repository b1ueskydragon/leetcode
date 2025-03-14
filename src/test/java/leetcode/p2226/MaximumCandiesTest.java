package leetcode.p2226;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCandiesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMaximumCandies(int[] candies, int k, int maxAllocation) {
        assertThat(underTest.maximumCandies(candies, k)).isEqualTo(maxAllocation);
    }

    static Stream<Arguments> testMaximumCandies() {
        return Stream.of(
                Arguments.of(new int[]{6, 2, 11, 6}, 4, 5),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{2, 5}, 11, 0)
        );
    }

}
