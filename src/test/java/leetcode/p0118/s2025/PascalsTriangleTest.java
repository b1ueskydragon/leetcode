package leetcode.p0118.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PascalsTriangleTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    @ParameterizedTest
    @MethodSource("testGenerate")
    void testV1(int numRows, List<List<Integer>> expected) {
        assertThat(v1.generate(numRows)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testGenerate")
    void testV2(int numRows, List<List<Integer>> expected) {
        assertThat(v2.generate(numRows)).isEqualTo(expected);
    }

    static Stream<Arguments> testGenerate() {
        return Stream.of(
                Arguments.of(5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1)))
        );
    }

}
