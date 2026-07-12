package leetcode.p1331;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayRankTransformTest {

    private SolutionV1 v1;
    private SolutionV2 v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] arr, int[] ranked) {
        assertThat(v1.arrayRankTransform(arr)).isEqualTo(ranked);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] arr, int[] ranked) {
        assertThat(v2.arrayRankTransform(arr)).isEqualTo(ranked);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12},
                        new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3}
                ),
                Arguments.of(
                        new int[]{1000000000, 1, -1, 100, -100, 1000, -1000, -1000000000, -1000000000, 1000000000, 1000000000},
                        new int[]{8, 5, 4, 6, 3, 7, 2, 1, 1, 8, 8}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{0},
                        new int[]{1}
                )
        );
    }

}
