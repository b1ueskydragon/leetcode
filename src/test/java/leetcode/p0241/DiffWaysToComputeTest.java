package leetcode.p0241;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DiffWaysToComputeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testDiffWaysToCompute(String expression, List<Integer> expected) {
        assertThat(underTest.diffWaysToCompute(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("2*3-4*5", List.of(-34, -10, -14, -10, 10)),
                Arguments.of("2*3*4", List.of(24, 24)),
                Arguments.of("2+3", List.of(5)),
                Arguments.of("1+2+3", List.of(6, 6)),
                Arguments.of("10", List.of(10))
        );
    }

}
