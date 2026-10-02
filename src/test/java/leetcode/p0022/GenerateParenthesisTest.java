package leetcode.p0022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesisTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testGenerateParenthesis(int n, List<String> generated) {
        assertThat(underTest.generateParenthesis(n)).containsExactlyInAnyOrderElementsOf(generated);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        1, List.of("()")
                ),
                Arguments.of(
                        2, List.of("()()", "(())")
                ),
                Arguments.of(
                        3, List.of("()()()", "(())()", "()(())", "(()())", "((()))")
                ),
                Arguments.of(
                        4, List.of("()()()()", "(())()()", "()(())()", "()()(())", "(()())()", "()(()())", "((()))()", "()((()))", "(())(())", "(()()())", "((())())", "(()(()))", "((()()))", "(((())))")
                )
        );
    }

}
