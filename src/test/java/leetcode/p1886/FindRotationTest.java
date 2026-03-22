package leetcode.p1886;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindRotationTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindRotation(int[][] mat, int[][] target, boolean expected) {
        assertThat(underTest.findRotation(mat, target)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                // 外側が 2 rotations,
                // 内側が 1 or 3 rotation(s)
                Arguments.of(
                        new int[][]{
                                {1, 0, 0, 0},
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 0, 1, 0},
                                {0, 1, 0, 0},
                                {0, 0, 0, 1}
                        },
                        false
                ),
                // 外側が 3 rotations,
                // 内側が 1 or 3 rotation(s)
                Arguments.of(
                        new int[][]{
                                {1, 0, 0, 0},
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 0}
                        },

                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 0, 1, 0},
                                {0, 1, 0, 0},
                                {1, 0, 0, 0}
                        },
                        true
                )
        );
    }
}
