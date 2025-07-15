package leetcode.p0034;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SearchRangeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testSearchRange(int[] nums, int target, int[] expected) {
        assertThat(underTest.searchRange(nums, target)).isEqualTo(expected);
    }

    static Stream<Arguments> testSearchRange() {
        return Stream.of(
                Arguments.of(new int[]{6, 6, 7, 7, 8, 8, 8, 8, 8, 8, 8}, 8, new int[]{4, 10}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1})
        );
    }

}
