package leetcode.p0836;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsRectangleOverlapTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testIsRectangleOverlap(int[] rec1, int[] rec2, boolean expected) {
        assertThat(underTest.isRectangleOverlap(rec1, rec2)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{0, 0, 2, 2},
                        new int[]{1, 1, 3, 3},
                        true
                ),
                Arguments.of(
                        new int[]{0, 0, 1, 1},
                        new int[]{1, 0, 2, 1},
                        false
                ),
                Arguments.of(
                        new int[]{0, 0, 1, 1},
                        new int[]{2, 2, 3, 3},
                        false
                ),
                Arguments.of(
                        new int[]{1, 1, 4, 4},
                        new int[]{2, 2, 3, 3},
                        true
                ),
                Arguments.of(
                        new int[]{-4, -9, -2, 3},
                        new int[]{1, -5, 9, -1},
                        false
                ),
                Arguments.of(
                        new int[]{-9, 6, -3, 10},
                        new int[]{-8, -10, -5, -4},
                        false
                ),
                Arguments.of(
                        new int[]{512_320_138, 339_316_137, 683_242_142, 909_216_020},
                        new int[]{553_822_491, 613_363_800, 681_801_037, 899_732_269},
                        true
                ),
                Arguments.of(
                        new int[]{491_512_649, -528_380_151, 977_509_156, 620_803_381},
                        new int[]{977_509_191, -528_380_114, 1_000_000_000, -343_176_072},
                        false
                ),
                Arguments.of(
                        new int[]{-552_260_740, 909_854_970, -263_634_921, 942_191_543},
                        new int[]{-374_923_864, 915_642_060, -314_801_007, 930_370_357},
                        true
                )
        );
    }

}
