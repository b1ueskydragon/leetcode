package leetcode.p1021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveOuterParenthesesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "(()())(()), ()()()",
            "(()())(())(()(())), ()()()()(())",
            "()(), ''",
            "(())(), ()",
            "()()()()()((()))(((())))(()), (())((()))()",
            "(()()()()()((()))(((())))(())), ()()()()()((()))(((())))(())",
            "(), ''",
            "(((()))), ((()))"
    })
    void testRemoveOuterParentheses(String s, String outermostRemoved) {
        assertThat(underTest.removeOuterParentheses(s)).isEqualTo(outermostRemoved);
    }

}
