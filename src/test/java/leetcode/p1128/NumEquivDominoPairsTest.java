package leetcode.p1128;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumEquivDominoPairsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testNumEquivDominoPairs(int[][] dominoes, int pairsCount) {
        assertThat(underTest.numEquivDominoPairs(dominoes)).isEqualTo(pairsCount);
    }

    static Stream<Arguments> testNumEquivDominoPairs() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}, {9, 8}, {5, 7}, {7, 5}}, 4
                )
        );
    }

}
