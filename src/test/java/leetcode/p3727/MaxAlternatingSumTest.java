package leetcode.p3727;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxAlternatingSumTest {

    private SolutionV1 v1;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxAlternatingSum(int[] nums, long score) {
        assertThat(v1.maxAlternatingSum(nums)).isEqualTo(score);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 12),
                Arguments.of(new int[]{1, -1, 2, -2, 3, -3}, 16),
                Arguments.of(new int[]{40000, -40000, 39999, 39999}, 159998),
                Arguments.of(new int[]{-40000}, 1600000000),
                Arguments.of(new int[]{40000, -40000, 40000}, 1600000000),
                Arguments.of(new int[]{-18361, 5029, -38809, -37314, 25500, -20727, -8626, -28761, -11696, -4586, -3100, -19884, -25048, -4706, -32816, 27449, 27102, 23573, 14983, -27857, 30170, -23007, -36921, -31303, -703, 22452, -16959, 21716, -24173, 8670, -21779, 7344, -31579, 30871, -15623, 9473, -24763, 39378, -9230, 34604, 788, 30315, -17334, -21565, 22541, -27944, 21459, 9917, -21728, -2185, -31371, -14797, 39897, -23675, 8005, -23345, -35357, -22179, -17865, 9705, 28103, -26172, 21799, 14591, 5250, -5618, -14688, 31990, -27963, -24775, 7482, 7110, -14536, 2869, 34354, 7354, 25417, 25038, -25928, 30885, -38156, -4954, -31235, -8112, -9129, 37961, -12834, -31185, -209, 39375, 13524, -21801, -24577, -38840, -17419, -170, -4988, 33752, 4656, 1694, -23106, -36711, -5388, -16162, 16239, -160, 35722, 25846, -9485, 34950}, 41989480525L)
        );
    }

}
