package leetcode.p3147;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumEnergyTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumEnergy(int[] energy, int k, int expected) {
        assertThat(underTest.maximumEnergy(energy, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, -10, -5, 1}, 3, 3),
                Arguments.of(new int[]{-2, -3, -1}, 2, -1),
                Arguments.of(new int[]{5, 2, -10, -5, -1}, 2, -1),
                Arguments.of(new int[]{5, 2, -10, -5, -1}, 2, -1),
                Arguments.of(new int[]{868, -975, -150, -272, 652, -601, -50, -681, 950, 899, -643, 649, -576, 816, -747, 301, 310, -3, -508, -146, 213, -863, 117, 372, 738, -96, 173, -516, 539, -408, -192, 9, -745, -84, 984, -444, 568, -297, -158, -564, -93, 43, -144, 961, 499, 716, 819, 479, 354, 477, 912, 264, -624, 387, 821, -278, 244, 39, 250, 441, 678, 566, 776, 818, 233, -784, -31, -747, -990, -603, 879, -993, -809, 913, -121, 172, 314, -85, -532, 875, -485, 751, 969, -59, -569, -894, 53, -288, 176, 55, 790, 256, 389, -235, -246, -41, -454, 275, 790}, 6, 4636),
                Arguments.of(new int[]{868, -975, -150, -272, 652, -601, -50, -681, 950, 899, -643, 649, -576, 816, -747, 301, 310, -3, -508, -146, 213, -863, 117, 372, 738, -96, 173, -516, 539, -408, -192, 9, -745, -84, 984, -444, 568, -297, -158, -564, -93, 43, -144, 961, 499, 716, 819, 479, 354, 477, 912, 264, -624, 387, 821, -278, 244, 39, 250, 441, 678, 566, 776, 818, 233, -784, -31, -747, -990, -603, 879, -993, -809, 913, -121, 172, 314, -85, -532, 875, -485, 751, 969, -59, -569, -894, 53, -288, 176, 55, 790, 256, 389, -235, -246, -41, -454, 275, 790}, 1, 8977)
        );
    }
}
