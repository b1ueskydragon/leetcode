package leetcode.p1550;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeConsecutiveOddsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testThreeConsecutiveOdds(int[] arr, boolean expected) {
        assertThat(underTest.threeConsecutiveOdds(arr)).isEqualTo(expected);
    }

    static Stream<Arguments> testThreeConsecutiveOdds() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}, true),
                Arguments.of(new int[]{1, 2, 34, 3, 4, 5, 7, 7, 5, 23, 12}, true),
                Arguments.of(new int[]{1, 2, 34, 3, 4, 5, 7, 2, 5, 7, 2, 5, 2, 23, 12}, false)
        );
    }
}
