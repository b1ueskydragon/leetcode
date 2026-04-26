package leetcode.p1559;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsCycleTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testContainsCycle(char[][] grid, boolean expected) {
        assertThat(underTest.containsCycle(grid)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'c', 'c', 'c', 'c'},
                                {'c', 'a', 'c', 'a'}
                        },
                        false
                ),
                Arguments.of(
                        new char[][]{
                                {'c', 'c', 'c', 'a'},
                                {'c', 'd', 'c', 'c'},
                                {'c', 'c', 'c', 'e'},
                                {'f', 'c', 'c', 'c'}
                        },
                        true
                ),
                Arguments.of(
                        new char[][]{
                                {'a', 'a', 'a', 'a'},
                                {'a', 'b', 'b', 'a'},
                                {'a', 'b', 'b', 'a'},
                                {'a', 'a', 'a', 'a'}
                        },
                        true
                )
        );
    }
}
