package leetcode.p0050;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class P0050Test {

    private final Solution instance = new Solution();
    private static final Percentage PER = Percentage.withPercentage(1e-3);

    @ParameterizedTest
    @CsvSource({
            "2.00000, 10",
            "2.1000, 3",
            "2.1, 7",
            "3, 4",
            "3, 5",
            "-99, 2",
            "1.00000, 2147483647",
    })
    void positiveN(double x, int n) {
        final var expected = Math.pow(x, n);
        assertThat(instance.myPow0(x, n)).isCloseTo(expected, PER);
        assertThat(instance.myPow1(x, n)).isCloseTo(expected, PER);
        assertThat(instance.myPow2(x, n)).isCloseTo(expected, PER);
    }

    @ParameterizedTest
    @CsvSource({
            // equivalent to #positiveN cases
            "2.00000, 10",
            "2.1000, 3",
            "2.1, 7",
            "3, 4",
            "3, 5",
            "-99, 2",
            "1.00000, 2147483647",

            // n is negative
            "2.00000, -2",
            "4.00, -2",
            "-99, -99",

            // edge cases
            // n cannot be converted to positive properly
            "2.00000, -2147483648",
            "-1.00000, -2147483648",
            "1.00000, -2147483648"
    })
    void nCouldBeNegative(double x, int n) {
        final var expected = Math.pow(x, n);
        assertThat(instance.myPow3(x, n)).isCloseTo(expected, PER);
        assertThat(instance.myPow4(x, n)).isCloseTo(expected, PER);
        assertThat(instance.myPow5(x, n)).isCloseTo(expected, PER);
        assertThat(instance.myPow6(x, n)).isCloseTo(expected, PER);
    }
}
