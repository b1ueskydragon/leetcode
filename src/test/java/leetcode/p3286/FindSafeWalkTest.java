package leetcode.p3286;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindSafeWalkTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindSafeWalk(List<List<Integer>> grid, int health, boolean isReachable) {
        assertThat(underTest.findSafeWalk(grid, health)).isEqualTo(isReachable);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(0, 1, 0, 0, 0),
                                List.of(0, 1, 0, 1, 0),
                                List.of(0, 0, 0, 1, 0)
                        ),
                        1,
                        true
                ),
                Arguments.of(
                        List.of(
                                List.of(0, 1, 1, 0, 0, 0),
                                List.of(1, 0, 1, 0, 0, 0),
                                List.of(0, 1, 1, 1, 0, 1),
                                List.of(0, 0, 1, 0, 1, 0)
                        ),
                        3,
                        false
                ),
                Arguments.of(
                        List.of(
                                List.of(1, 1, 1),
                                List.of(1, 0, 1),
                                List.of(1, 1, 1)
                        ),
                        5,
                        true
                ),
                // Edge case: a valid path exists, even though the shortest path is invalid.
                Arguments.of(
                        List.of(
                                List.of(0, 0, 0, 0, 1),
                                List.of(1, 1, 1, 0, 1),
                                List.of(1, 1, 0, 0, 1),
                                List.of(1, 1, 0, 0, 0)
                        ),
                        1,
                        true
                ),
                Arguments.of(
                        List.of(
                                List.of(0, 0, 0, 0, 1),
                                List.of(1, 1, 1, 0, 1),
                                List.of(1, 1, 0, 0, 1),
                                List.of(1, 1, 0, 0, 0),
                                List.of(1, 1, 1, 0, 1),
                                List.of(1, 1, 1, 0, 0),
                                List.of(1, 1, 0, 0, 1),
                                List.of(1, 1, 1, 0, 1),
                                List.of(0, 0, 0, 0, 1),
                                List.of(1, 1, 1, 0, 1),
                                List.of(1, 1, 0, 0, 1),
                                List.of(1, 1, 0, 0, 0),
                                List.of(1, 1, 1, 0, 1),
                                List.of(1, 1, 1, 0, 0),
                                List.of(1, 1, 0, 0, 1),
                                List.of(1, 1, 1, 0, 1)
                        ),
                        2,
                        true
                )
        );
    }

}
