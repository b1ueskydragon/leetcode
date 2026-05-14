package leetcode.p2784;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsGoodTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testDistance(int[] nums, boolean expected) {
        assertThat(underTest.isGood(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 3}, true),
                Arguments.of(new int[]{1, 1}, true),
                Arguments.of(new int[]{3, 4, 4, 1, 2, 1}, false),
                Arguments.of(new int[]{2, 2, 2, 3}, false)
        );
    }

}
