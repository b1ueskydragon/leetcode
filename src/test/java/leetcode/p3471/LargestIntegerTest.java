package leetcode.p3471;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestIntegerTest {

    private Solution2026V1 s2026v1;
    private Solution2026V2 s2026v2;

    @BeforeEach
    void setUp() {
        s2026v1 = new Solution2026V1();
        s2026v2 = new Solution2026V2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void test2026V1(int[] nums, int k, int expected) {
        assertThat(s2026v1.largestInteger(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void test2026V2(int[] nums, int k, int expected) {
        assertThat(s2026v2.largestInteger(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 9, 2, 1, 7},
                        3,
                        7
                ),
                Arguments.of(
                        new int[]{0, 0},
                        1,
                        -1
                ),
                Arguments.of(
                        new int[]{0, 0},
                        2,
                        0
                ),
                Arguments.of(
                        new int[]{1, 0},
                        2,
                        1
                ),
                Arguments.of(
                        new int[]{0, 0, 1},
                        3,
                        1
                ),
                Arguments.of(
                        new int[]{0, 0, 0, 0, 1, 1, 1, 1},
                        8,
                        1
                ),
                Arguments.of(
                        new int[]{30, 31, 30, 21, 31, 17, 45, 38, 7, 3, 39, 42, 19, 49, 19, 20},
                        10,
                        20
                ),
                Arguments.of(
                        new int[]{30, 31, 30, 21, 31, 17, 45, 38, 7, 3, 39, 42, 19, 20, 19, 20},
                        10,
                        -1
                )
        );
    }

}
