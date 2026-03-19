package leetcode.p3212;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfSubmatricesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNumberOfSubmatrices(char[][] grid, int count) {
        assertThat(underTest.numberOfSubmatrices(grid)).isEqualTo(count);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'X', 'Y', '.'},
                                {'Y', ',', 'Y'}
                        },
                        3
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X'},
                                {'X', 'Y'}
                        },
                        0
                ),
                Arguments.of(
                        new char[][]{
                                {'.', '.'},
                                {'.', '.'}
                        },
                        0
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'Y'},
                                {'Y', 'Y', 'X'}
                        },
                        3
                )
        );
    }
}
