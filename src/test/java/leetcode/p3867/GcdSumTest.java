package leetcode.p3867;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GcdSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testGcdSum(int[] nums, int sum) {
        assertThat(underTest.gcdSum(nums)).isEqualTo(sum);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 6, 4}, 2),
                Arguments.of(new int[]{3, 6, 2, 8}, 5),
                Arguments.of(new int[]{1, 1, 1, 1000000000, 1, 1, 1}, 3),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1000000000}, 0)
        );
    }

}
