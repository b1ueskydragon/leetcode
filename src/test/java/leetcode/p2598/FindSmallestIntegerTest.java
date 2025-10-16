package leetcode.p2598;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindSmallestIntegerTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindSmallestInteger(int[] nums, int value, int expected) {
        assertThat(underTest.findSmallestInteger(nums, value)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, -10, 7, 13, 6, 8}, 7, 2),
                Arguments.of(new int[]{100, 101, 102}, 7, 0),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 8, 8),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 1, 8),
                Arguments.of(new int[]{999999999, 100002, -56128323, 1000000000, 418281488, -1000000000, 681559523, -614558629, 773932439, -777204685, -999999999, 0}, 100000, 3)
        );
    }
}
