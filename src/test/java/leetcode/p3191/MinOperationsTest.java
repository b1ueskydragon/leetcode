package leetcode.p3191;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void minOperationsTest(int[] nums, int theMinNumOfOperation) {
        assertThat(underTest.minOperations(nums)).isEqualTo(theMinNumOfOperation);
    }

    static Stream<Arguments> minOperationsTest() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 1, 1, 0, 0}, 3),
                Arguments.of(new int[]{0, 1, 1, 1}, -1),
                Arguments.of(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1}, -1),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 8),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0),
                Arguments.of(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 6)
        );
    }
}
