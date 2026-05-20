package leetcode.p2657;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindThePrefixCommonArrayTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] A, int[] B, int[] ans) {
        assertThat(v1.findThePrefixCommonArray(A, B)).isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] A, int[] B, int[] ans) {
        assertThat(v2.findThePrefixCommonArray(A, B)).isEqualTo(ans);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 2, 4},
                        new int[]{3, 1, 2, 4},
                        new int[]{0, 2, 3, 4}
                ),

                Arguments.of(
                        new int[]{2, 3, 1},
                        new int[]{3, 1, 2},
                        new int[]{0, 1, 3}
                ),

                Arguments.of(
                        new int[]{39, 31, 37, 45, 34, 21, 16, 15, 14, 38, 36, 43, 3, 19, 1, 10, 29, 49, 20, 48, 42, 23, 2, 32, 24, 50, 5, 28, 17, 33, 40, 22, 44, 6, 18, 11, 26, 46, 27, 35, 41, 13, 30, 47, 25, 12, 4, 8, 7, 9},
                        new int[]{41, 16, 50, 15, 40, 25, 39, 31, 14, 44, 42, 10, 18, 23, 22, 9, 49, 38, 17, 12, 2, 21, 20, 30, 27, 37, 28, 1, 3, 45, 33, 11, 46, 43, 13, 48, 6, 32, 24, 7, 29, 35, 8, 36, 26, 4, 19, 47, 34, 5},
                        new int[]{0, 0, 0, 0, 0, 0, 2, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 8, 8, 8, 9, 11, 13, 13, 13, 15, 15, 17, 19, 20, 22, 23, 24, 25, 26, 28, 29, 31, 33, 33, 35, 37, 38, 39, 41, 42, 44, 46, 48, 50}
                ),

                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8}
                ),

                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{8, 7, 6, 5, 4, 3, 2, 1},
                        new int[]{0, 0, 0, 0, 2, 4, 6, 8}
                )
        );
    }
}
