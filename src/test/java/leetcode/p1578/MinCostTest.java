package leetcode.p1578;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinCost(String colors, int[] neededTime, int minCost) {
        assertThat(underTest.minCost(colors, neededTime)).isEqualTo(minCost);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("abaac", new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of("abc", new int[]{1, 2, 3}, 0),
                Arguments.of("aabaa", new int[]{1, 2, 3, 4, 1}, 2),
                Arguments.of("aabbbaaabababbbbababbba", new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 10),
                Arguments.of("abcabcabcabcababbbbbbbaaaaacccccbbcbcbcbcbazcbacbd", new int[]{1, 1, 1, 4, 4, 4, 4, 3, 2, 3, 4, 5, 6, 7, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1}, 18)
        );
    }

}
