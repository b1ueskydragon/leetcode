package leetcode.p2257;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountUnguardedTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void countUnguarded(int m, int n, int[][] guards, int[][] walls, int unguarded) {
        assertThat(underTest.countUnguarded(m, n, guards, walls)).isEqualTo(unguarded);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}, 7),
                Arguments.of(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}, 4)
        );
    }
}
