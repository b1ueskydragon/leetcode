package leetcode.p1614;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDepthTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaxDepth(String s, int maxDepth) {
        assertThat(underTest.maxDepth(s)).isEqualTo(maxDepth);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "(1+(2*3)+((8)/4))+1",
                        3
                ),
                Arguments.of(
                        "(1)+((2))+(((3)))",
                        3
                ),
                Arguments.of(
                        "()(())((()()))",
                        3
                ),
                Arguments.of(
                        "(((()))()(())(((())))((()))(((())))((((()))())))",
                        6
                )
        );
    }

}
