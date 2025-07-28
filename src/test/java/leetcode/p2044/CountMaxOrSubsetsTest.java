package leetcode.p2044;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountMaxOrSubsetsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void countMaxOrSubsets(int[] nums, int count) {
        assertThat(underTest.countMaxOrSubsets(nums)).isEqualTo(count);
    }

    static Stream<Arguments> countMaxOrSubsets() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 5}, 6),
                Arguments.of(new int[]{3, 1}, 2),
                Arguments.of(new int[]{2, 2, 2}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 805),
                Arguments.of(new int[]{100000}, 1)
        );
    }

}
