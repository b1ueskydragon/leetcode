package leetcode.p1390;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumFourDivisorsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void sumFourDivisors(int[] nums, int sumOfDivisors) {
        assertThat(underTest.sumFourDivisors(nums)).isEqualTo(sumOfDivisors);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{21, 4, 7}, 32),
                Arguments.of(new int[]{21, 21}, 64),
                Arguments.of(new int[]{8, 27, 64}, 55),
                Arguments.of(new int[]{99990, 99991, 99992, 99993, 99994, 99995, 99996, 99997, 99998, 99999, 99990, 99991, 99992, 99993, 99994, 99995, 99996, 99997, 99998, 99999}, 566656),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 0)
        );
    }
}
