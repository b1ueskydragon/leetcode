package leetcode.p0022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesisTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution2026V1();
        v2 = new Solution2026V2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int n, List<String> generated) {
        assertThat(v1.generateParenthesis(n)).containsExactlyInAnyOrderElementsOf(generated);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int n, List<String> generated) {
        assertThat(v2.generateParenthesis(n)).containsExactlyInAnyOrderElementsOf(generated);
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
