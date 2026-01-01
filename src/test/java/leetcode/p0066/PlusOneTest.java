package leetcode.p0066;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOneTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testPlusOne(int[] digits, int[] expected) {
        assertThat(underTest.plusOne(digits)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{1, 9, 9, 9}, new int[]{2, 0, 0, 0}),
                Arguments.of(new int[]{1, 0, 9, 9}, new int[]{1, 1, 0, 0}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}),
                Arguments.of(new int[]{2, 0, 2, 5}, new int[]{2, 0, 2, 6}),
                Arguments.of(new int[]{8, 9, 9}, new int[]{9, 0, 0})
        );
    }

}
