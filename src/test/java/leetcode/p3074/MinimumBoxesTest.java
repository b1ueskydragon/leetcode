package leetcode.p3074;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumBoxesTest {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumBoxes(int[] apple, int[] capacity, int minimumBoxes) {
        assertThat(underTest.minimumBoxes(apple, capacity)).isEqualTo(minimumBoxes);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 13}, new int[]{5, 5, 5}, 3),
                Arguments.of(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}, 4),
                Arguments.of(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}, 2),
                Arguments.of(new int[]{50, 1, 2, 10}, new int[]{4, 5, 2, 1, 1, 1, 2, 3, 4, 7, 1, 2, 2, 2, 3, 1, 3, 2, 2, 2, 1, 2, 2, 4, 3, 5, 3, 5, 5, 5, 5, 5, 4, 1, 1, 2, 4, 4, 1, 1, 2, 4, 3, 3, 2, 1, 5, 5, 1, 4}, 13)
        );
    }

}
