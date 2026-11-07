package leetcode.p1385;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheDistanceValueTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindTheDistanceValue(int[] arr1, int[] arr2, int d, int number) {
        assertThat(underTest.findTheDistanceValue(arr1, arr2, d)).isEqualTo(number);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{4}, new int[]{4}, 0, 0),
                Arguments.of(new int[]{4}, new int[]{1, 3, 5, 7, 9}, 0, 1),
                Arguments.of(new int[]{6}, new int[]{1, 3, 5, 7, 9}, 0, 1),
                Arguments.of(new int[]{4, 5, 8}, new int[]{1, 8, 9, 10}, 2, 2),
                Arguments.of(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3, 2),
                Arguments.of(new int[]{2, 1, 100, 3}, new int[]{-5, -3, -2, 7, 10}, 6, 1),
                Arguments.of(new int[]{-3, -3, 4, -1, -10}, new int[]{7, 10}, 12, 1),
                Arguments.of(
                        new int[]{
                                -636, -388, -114, 100, -677, -901, 463, 765, 367, -494,
                                -483, 592, -869, 396, 973, -86, 655, -120, 124, -488,
                                108, -101, 743, 101, -72, -978, -190, 712, -307, -649,
                                -472, -6, -951, 624, 323, 910, -147, 999, 168, -962,
                                -873, 416, -274, 187, -717, 215, -744, -717, -470, 697,
                                -433, -186, 155, -179, -648, 254, -818, -522, -5, -985,
                                -637, 82, -351, 25, 828, 328, 885, -103, 904, 405,
                                308, 497, -538, -512, -360, 13, 406, -20, 958, -540,
                                459, -156, -310, 147, 251, 857, 491, 879, 338, -437,
                                991, 323, -551, -902, 887, -854, 563, 47
                        },
                        new int[]{
                                321, 796, -245, -674, 47, 568, 622, 808, -583, -362,
                                -389, 418, -387, 738, 131, -239, -662, 436, 436, 508,
                                -49, 217, -826, 753, -748, 836, 241, 966, 52, 169,
                                -228, -639, -681, -487, -127, -555
                        },
                        72,
                        6
                )
        );
    }

}
