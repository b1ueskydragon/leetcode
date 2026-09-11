package leetcode.p3483;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TotalNumbersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testTotalNumbers(int[] digits, int count) {
        assertThat(underTest.totalNumbers(digits)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        12
                ),
                Arguments.of(
                        new int[]{0, 2, 2},
                        2
                ),
                Arguments.of(
                        new int[]{6, 6, 6},
                        1
                ),
                Arguments.of(
                        new int[]{2, 4, 6, 8, 2, 4, 6, 8, 2},
                        61
                ),
                Arguments.of(
                        new int[]{0, 0, 0, 9, 9, 9, 1, 1, 1, 5},
                        11
                ),
                Arguments.of(
                        new int[]{0, 0, 0},
                        0
                ),
                Arguments.of(
                        new int[]{1, 2, 1},
                        1
                ),
                Arguments.of(
                        new int[]{2, 4, 6, 8, 0},
                        48
                )
        );
    }

}
