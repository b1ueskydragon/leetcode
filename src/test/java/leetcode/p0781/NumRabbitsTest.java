package leetcode.p0781;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumRabbitsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testNumRabbits(int[] answers, int minRabbits) {
        assertThat(underTest.numRabbits(answers)).isEqualTo(minRabbits);
    }

    static Stream<Arguments> testNumRabbits() {
        return Stream.of(
                // e.g., RR BBB
                Arguments.of(new int[]{1, 1, 2}, 5),
                Arguments.of(new int[]{1, 1, 2, 2}, 5),
                Arguments.of(new int[]{1, 1, 2, 2, 2}, 5),
                // We need to add a new group
                // e.g., RR BBB GGG
                Arguments.of(new int[]{1, 1, 2, 2, 2, 2}, 8),
                Arguments.of(new int[]{1, 1, 2, 2, 2, 2, 2}, 8),
                Arguments.of(new int[]{1, 1, 2, 2, 2, 2, 2, 2}, 8),
                // Edge cases
                Arguments.of(new int[]{10, 10, 10}, 11),
                Arguments.of(new int[]{998, 1, 2, 0, 0, 999}, 2006)
        );
    }
}
