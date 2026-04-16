package leetcode.p3488;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolveQueriesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSolveQueries(int[] nums, int[] queries, List<Integer> ans) {
        assertThat(underTest.solveQueries(nums, queries)).isEqualTo(ans);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 1, 4, 1, 3, 2},
                        new int[]{0, 3, 5},
                        List.of(2, -1, 3)
                ),
                Arguments.of(
                        new int[]{2, 10, 20, 20, 20},
                        new int[]{1, 4, 2},
                        List.of(-1, 1, 1)
                ),
                Arguments.of(
                        new int[]{17, 7, 19, 16, 17, 16, 16, 4, 12, 5, 8, 1, 2, 16, 9, 5, 17, 16, 17, 16},
                        new int[]{7, 12, 9, 11, 19, 15, 6, 16},
                        List.of(-1, -1, 6, -1, 2, 6, 1, 2)
                ),
                Arguments.of(
                        new int[]{9, 3, 9, 3, 3, 3, 11, 3, 18, 3, 7, 9, 11, 7, 6, 14, 3, 5},
                        new int[]{17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7},
                        List.of(-1, 3, -1, -1, 3, 6, 7, 3, 2, -1, 2)
                ),
                Arguments.of(
                        new int[]{9, 3, 9, 3, 3, 3, 11, 3, 18, 3, 7, 9, 11, 7, 6, 14, 3, 5},
                        new int[]{6, 5, 4, 3, 2, 1, 0},
                        List.of(6, 1, 1, 1, 2, 2, 2)
                ),
                Arguments.of(
                        new int[]{9, 3, 9, 3, 3, 3, 11, 3, 18, 3, 7, 9, 11, 7, 6, 14, 3, 5},
                        new int[]{6, 5, 4, 3, 2, 1, 0},
                        List.of(6, 1, 1, 1, 2, 2, 2)
                )
        );
    }

}
