package leetcode.p1523;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountOddsTest {

    private Solution s2025;
    private Solution s2023;

    @BeforeEach
    void setUp() {
        s2025 = new Solution2023();
        s2023 = new Solution2023();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2025(int low, int high, int count) {
        assertThat(s2025.countOdds(low, high)).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2023(int low, int high, int count) {
        assertThat(s2023.countOdds(low, high)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(0, 1000000000, 500000000),
                Arguments.of(1, 1000000000, 500000000),
                Arguments.of(1, 999999999, 500000000),
                Arguments.of(0, 999999999, 500000000)
        );
    }

}
