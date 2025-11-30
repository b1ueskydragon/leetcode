package leetcode.p0525;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaxLengthTest {

    private Solution v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] nums, int expected) {
        assertThat(v1.findMaxLength(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}, 6),
                Arguments.of(new int[]{0, 1, 1, 0, 1, 1, 0, 1}, 4),
                Arguments.of(new int[]{0, 1, 1, 0, 1, 1, 0, 0}, 8),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1}, 4),
                Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1}, 8)
        );
    }

}
