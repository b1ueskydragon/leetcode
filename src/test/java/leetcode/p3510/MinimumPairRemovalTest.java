package leetcode.p3510;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumPairRemovalTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumPairRemoval(int[] nums, int operationCount) {
        assertThat(underTest.minimumPairRemoval(nums)).isEqualTo(operationCount);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 3, 1}, 2),
                Arguments.of(new int[]{5, 1, 3, 2}, 2),
                Arguments.of(new int[]{1, 2, 2}, 0),
                Arguments.of(new int[]{100, -200, 100}, 1),
                Arguments.of(new int[]{1000, -1000, -1000, 1000}, 2),
                Arguments.of(new int[]{-1000}, 0),
                Arguments.of(new int[]{-1000, -1000, -999, -1000, -1000, -999, -999, -1000, -1000, -1000, -1000, -1000, -1000, -999, -999, -1000, -999, -999, -1000, -999, -1000, -1000, -1000, -1000, -999, -999, -999, -999, -1000, -999, -1000, -1000, -999, -1000, -1000, -1000, -1000, -1000, -999, -1000, -1000, -1000, -999, -999, -999, -1000, -1000, -999, -999, -999}, 44),
                Arguments.of(new int[]{401, 435, -314, -177, 61, 756, -908, 819, 993, 880, -527, -100, -604, 100, -851, -730, -300, -115, 281, 781, 25, -670, 683, -362, 659, 652, 855, 673, -500, -150, 971, -914, -917, -973, 193, 664, -383, -517, 763, 378, -557, -650, 103, 585, -323, -572, -957, 372, 504, 128}, 48)
        );
    }

}
