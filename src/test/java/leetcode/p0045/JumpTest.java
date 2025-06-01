package leetcode.p0045;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class JumpTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testJump(int[] nums, int jumps) {
        assertThat(underTest.jump(nums)).isEqualTo(jumps);
    }

    static Stream<Arguments> testJump() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4, 1, 1, 1, 1, 1, 2}, 5),
                // No need to jump at all
                Arguments.of(new int[]{0}, 0)
        );
    }
}
