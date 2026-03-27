package leetcode.p2946;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AreSimilarTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void areSimilar(int[][] mat, int k, boolean expected) {
        assertThat(underTest.areSimilar(mat, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {5, 4, 5, 10, 5}
                        },
                        9,
                        false
                ),
                Arguments.of(
                        new int[][]{
                                {3, 3, 3, 3, 3, 3},
                                {5, 3, 5, 3, 5, 3},
                                {2, 5, 2, 5, 2, 5},
                                {8, 8, 8, 8, 8, 8},
                                {3, 8, 3, 8, 3, 8},
                                {5, 3, 5, 3, 5, 3},
                                {1, 8, 1, 8, 1, 8},
                                {8, 9, 8, 9, 8, 9},
                                {2, 8, 2, 8, 2, 8}
                        },
                        4,
                        true
                ),
                Arguments.of(
                        new int[][]{
                                {15, 15, 8}
                        },
                        1,
                        false
                ),
                Arguments.of(
                        new int[][]{
                                {13, 24, 13, 23}
                        },
                        42,
                        false
                )
        );
    }

}
