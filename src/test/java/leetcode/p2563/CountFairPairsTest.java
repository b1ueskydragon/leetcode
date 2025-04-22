package leetcode.p2563;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountFairPairsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testCountFairPairs(int[] nums, int lower, int upper, int count) {
        assertThat(underTest.countFairPairs(nums, lower, upper)).isEqualTo(count);
    }

    static Stream<Arguments> testCountFairPairs() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 7, 4, 4, 5}, 3, 6, 6),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0, 0, 15)
        );
    }
}
