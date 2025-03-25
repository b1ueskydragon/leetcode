package leetcode.p0213;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RobIITest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testRobII(int[] nums, int maxSum) {
        assertThat(underTest.rob(nums)).isEqualTo(maxSum);
    }

    static Stream<Arguments> testRobII() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{99}, 99),
                Arguments.of(new int[]{
                        0, 41, 322, 373, 265, 16, 184, 370, 33, 275, 383, 309, 196, 29, 318, 114, 242,
                        206, 226, 370, 372, 156, 59, 317, 6, 304, 81, 307, 1, 205, 214, 20, 382, 123,
                        294, 250, 125, 110, 38, 293, 326, 378, 166, 335, 330, 191, 308, 287, 101, 332,
                        1, 193}, 6651)
        );
    }
}
