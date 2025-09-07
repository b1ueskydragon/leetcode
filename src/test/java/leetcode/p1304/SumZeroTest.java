package leetcode.p1304;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumZeroTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSumZero(int value, int[] expected) {
        assertThat(underTest.sumZero(value)).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(1, new int[]{0}),
                Arguments.of(2, new int[]{-1, 1}),
                Arguments.of(3, new int[]{-1, 0, 1}),
                Arguments.of(4, new int[]{-2, -1, 1, 2}),
                Arguments.of(5, new int[]{-2, -1, 0, 1, 2})
        );
    }

}
