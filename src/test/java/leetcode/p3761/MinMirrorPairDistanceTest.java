package leetcode.p3761;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinMirrorPairDistanceTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] nums, int best) {
        assertThat(v1.minMirrorPairDistance(nums)).isEqualTo(best);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] nums, int best) {
        assertThat(v2.minMirrorPairDistance(nums)).isEqualTo(best);
    }


    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{12, 34, 46, 21, 12}, 1),
                Arguments.of(new int[]{21, 13, 14, 15, 12, 12, 45, 21, 45, 21, 33, 53}, 2),
                Arguments.of(new int[]{7, 7, 6, 7}, 1),
                Arguments.of(new int[]{10, 1, 10, 1, 10, 1, 10, 1, 10, 1}, 1),
                Arguments.of(new int[]{13, 31, 20, 31}, 1),
                Arguments.of(new int[]{3, 4, 5, 6, 7, 1, 1}, 1),
                Arguments.of(new int[]{120, 21}, 1),
                Arguments.of(new int[]{21, 120}, -1)
        );
    }

}
