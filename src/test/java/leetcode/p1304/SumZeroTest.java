package leetcode.p1304;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumZeroTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int value, int[] expected) {
        assertThat(v2.sumZero(value)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int value, int[] expected) {
        assertThat(v1.sumZero(value)).containsExactlyInAnyOrder(expected);
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
