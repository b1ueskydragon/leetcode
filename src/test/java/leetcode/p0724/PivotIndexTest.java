package leetcode.p0724;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PivotIndexTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPivotIndex(int[] nums, int index) {
        assertThat(underTest.pivotIndex(nums)).isEqualTo(index);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{2, 1, -1}, 0),
                Arguments.of(new int[]{1, -1, 2}, 2),
                Arguments.of(new int[]{1, 7, 3, 1, 0, 0, 0, 6, 2, 5, 6}, -1),
                Arguments.of(new int[]{1, 2, 0, 0, 0, 0, 0, 0, 0, 3}, 2),
                Arguments.of(new int[]{-1, -1, 0, 0, -1, -1}, 2),
                Arguments.of(new int[]{-1, -1, -1, -1, 0, 1}, 1)
        );
    }

}
