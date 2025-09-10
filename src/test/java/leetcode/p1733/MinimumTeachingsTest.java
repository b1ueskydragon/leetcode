package leetcode.p1733;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumTeachingsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinimumTeachings(int n, int[][] languages, int[][] friendships, int expected) {
        assertThat(underTest.minimumTeachings(n, languages, friendships)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}}, 1),
                Arguments.of(3, new int[][]{{2}, {1, 3}, {1, 2}, {3}}, new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}, 2)
        );
    }

}
