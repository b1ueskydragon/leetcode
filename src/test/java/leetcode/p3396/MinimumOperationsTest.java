package leetcode.p3396;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMinimumOperations(int[] nums, int count) {
        assertThat(underTest.minimumOperations(nums)).isEqualTo(count);
    }

    static Stream<Arguments> testMinimumOperations() {
        return Stream.of(
                // Scanning from the right...

                // split from i=5
                Arguments.of(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}, 2),
                // split from i=3
                Arguments.of(new int[]{4, 5, 6, 4, 4}, 2),
                // no need to split
                Arguments.of(new int[]{6, 7, 8, 9}, 0)
        );
    }
}
