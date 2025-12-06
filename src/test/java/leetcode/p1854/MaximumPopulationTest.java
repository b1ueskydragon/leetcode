package leetcode.p1854;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumPopulationTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumPopulation(int[][] logs, int earliest) {
        assertThat(underTest.maximumPopulation(logs)).isEqualTo(earliest);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}, 1960),
                Arguments.of(new int[][]{{1950, 2050}, {1960, 1965}, {1950, 2040}}, 1960)
        );
    }

}
