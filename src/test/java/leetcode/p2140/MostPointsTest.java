package leetcode.p2140;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MostPointsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testMostPoints(int[][] questions, int maxPoint) {
        assertThat(underTest.mostPoints(questions)).isEqualTo(maxPoint);
    }

    static Stream<Arguments> testMostPoints() {
        return Stream.of(
                Arguments.of(new int[][]{{7, 1}, {8, 2}, {1, 1}, {1, 1}, {1, 3}, {9, 6}}, 17)
        );
    }
}
