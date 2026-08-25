package leetcode.p3718;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingMultipleTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMissingMultiple(int[] nums, int k, int expected) {
        assertThat(underTest.missingMultiple(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{8, 2, 3, 4, 6}, 2, 10),
                Arguments.of(new int[]{1, 4, 7, 10, 15}, 5, 5),
                Arguments.of(new int[]{42, 13, 99, 13, 71, 32, 64, 32, 63, 44, 6, 22, 8, 2, 55, 88, 43, 40, 71, 80, 95, 32, 46, 19}, 44, 132),
                Arguments.of(new int[]{1, 45, 90, 100}, 45, 135)
        );
    }

}
