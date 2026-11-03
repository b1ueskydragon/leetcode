package leetcode.p3736;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinMovesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinMoves(int[] nums, int minMoves) {
        assertThat(underTest.minMoves(nums)).isEqualTo(minMoves);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3}, 3),
                Arguments.of(new int[]{4, 4, 5}, 2),
                Arguments.of(new int[]{1, 100, 99, 100, 50, 2}, 248)
        );
    }

}
