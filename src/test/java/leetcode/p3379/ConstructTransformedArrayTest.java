package leetcode.p3379;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructTransformedArrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testConstructTransformedArray(int[] nums, int[] result) {
        assertThat(underTest.constructTransformedArray(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{3, -2, 1, 1}, new int[]{1, 1, 1, 3}),
                Arguments.of(new int[]{-10, -10}, new int[]{-10, -10}),
                Arguments.of(new int[]{-1, -2, -3, -4}, new int[]{-4, -4, -4, -4}),
                Arguments.of(new int[]{-100}, new int[]{-100})
        );
    }

}
