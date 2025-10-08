package leetcode.p1488;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AvoidFloodTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void avoidFlood(int[] rains, int[] expected) {
        assertThat(underTest.avoidFlood(rains)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0, 2, 1}, new int[0]),
                Arguments.of(new int[]{1, 2, 0, 1, 0, 2, 0, 1}, new int[]{-1, -1, 1, -1, 2, -1, 1, -1}),
                Arguments.of(new int[]{11, 2, 33, 0, 0, 0, 11, 2, 33, 0, 0, 0, 11, 0, 2, 0, 33, 0, 0, 0, 0, 0, 0, 11, 2, 33, 0, 0, 0}, new int[]{-1, -1, -1, 11, 2, 33, -1, -1, -1, 11, 2, 33, -1, 11, -1, 2, -1, 33, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1}),
                Arguments.of(new int[]{7, 9, 0, 1, 7, 3, 0, 0, 0, 0, 0, 2, 3, 5, 7, 4, 1, 2, 0, 0, 3, 0, 9, 10, 10, 9, 3, 8, 3, 4, 4, 3, 3, 9, 3, 5, 5, 6, 9, 6, 8, 8, 0, 1, 8, 4, 3, 9, 2, 4, 4, 9, 9, 1, 8, 0, 0, 0, 0, 10, 1, 1, 0, 0, 0, 4, 5, 6, 2, 4, 8, 1, 2, 2, 10, 6, 4, 2, 8, 9, 6, 5, 5, 5, 2, 8, 6, 5, 0, 0, 0, 7, 10, 0, 6, 0, 3, 2, 8, 8, 4, 10, 1, 4, 8, 8, 7, 10, 8}, new int[0])
        );
    }
}
