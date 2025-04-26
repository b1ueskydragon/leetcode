package leetcode.p0904;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TotalFruitTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testTotalFruit(int[] fruits, int maximum) {
        assertThat(underTest.totalFruit(fruits)).isEqualTo(maximum);
    }

    static Stream<Arguments> testTotalFruit() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1}, 3),
                Arguments.of(new int[]{0, 1, 2, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 2, 2}, 4),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 15),
                Arguments.of(new int[]{
                        0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1,
                        1, 1, 1, 1, 2, 1, 2, 1}, 51),
                Arguments.of(new int[]{0}, 1)
        );
    }
}
