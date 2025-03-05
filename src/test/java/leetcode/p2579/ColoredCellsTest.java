package leetcode.p2579;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ColoredCellsTest {

    private SolutionV1 v1; // Recursive approach - Using relation X_n = X_{n-1} + 4*(n-1)
    private SolutionV2 v2; // Iterative approach - Converting recursion to loop to avoid stack overflow
    private SolutionV3 v3; // Summation approach - Reformulating as sum of arithmetic sequence
    private SolutionV4 v4; // Mathematical formula - Applying arithmetic sequence sum formula: 1 + 2*n*(n-1)

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
        v3 = new SolutionV3();
        v4 = new SolutionV4();
    }

    // All solution instances won't modify given `n` directly
    @ParameterizedTest
    @MethodSource
    void testColoredCells(int n, long theNumberOfColoredCells) {
//        assertThat(v1.coloredCells(n)).isEqualTo(theNumberOfColoredCells);
        assertThat(v2.coloredCells(n)).isEqualTo(theNumberOfColoredCells);
        assertThat(v3.coloredCells(n)).isEqualTo(theNumberOfColoredCells);
        assertThat(v4.coloredCells(n)).isEqualTo(theNumberOfColoredCells);
    }

    static Stream<Arguments> testColoredCells() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 5),
                Arguments.of(3, 13),
                Arguments.of(4, 25),
                Arguments.of(5, 41),
                Arguments.of(32768, 2147418113L),
                Arguments.of(100000, 19999800001L)
        );
    }
}
