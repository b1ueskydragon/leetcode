package leetcode.p1855;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDistanceTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] nums1, int[] nums2, int best) {
        assertThat(v1.maxDistance(nums1, nums2)).isEqualTo(best);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] nums1, int[] nums2, int best) {
        assertThat(v2.maxDistance(nums1, nums2)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{55, 30, 5, 4, 2},
                        new int[]{100, 20, 10, 10, 5},
                        2
                ),
                Arguments.of(
                        new int[]{30, 29, 19, 5},
                        new int[]{25, 25, 25, 25, 25},
                        2
                ),
                Arguments.of(
                        new int[]{10, 9, 8, 7, 6, 5},
                        new int[]{4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
                        0
                ),
                Arguments.of(
                        new int[]{1, 1, 1},
                        new int[]{1, 1, 1, 1},
                        3
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1},
                        new int[]{1, 1, 1},
                        2
                )
        );
    }

}
