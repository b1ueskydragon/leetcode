package leetcode.p1833;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxIceCreamTest {

    private Solution s2026;
    private Solution s2023;

    @BeforeEach
    void setUp() {
        s2026 = new Solution2026();
        s2023 = new Solution2023();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2026(int[] costs, int coins, int maxAmount) {
        assertThat(s2026.maxIceCream(costs, coins)).isEqualTo(maxAmount);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2023(int[] costs, int coins, int maxAmount) {
        assertThat(s2023.maxIceCream(costs, coins)).isEqualTo(maxAmount);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 2, 4, 1},
                        7,
                        4
                ),
                Arguments.of(
                        new int[]{10, 6, 8, 7, 7, 8},
                        5,
                        0
                ),
                Arguments.of(
                        new int[]{1, 6, 3, 1, 2, 5},
                        20,
                        6
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1, 1},
                        5,
                        5
                ),
                Arguments.of(
                        new int[]{2, 2, 2, 3},
                        9,
                        4
                ),
                Arguments.of(
                        new int[]{2, 2, 2, 3},
                        8,
                        3
                ),
                Arguments.of(
                        new int[]{2, 2, 2, 3},
                        10,
                        4
                )
        );
    }
}
