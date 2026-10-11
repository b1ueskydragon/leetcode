package leetcode.p0856;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreOfParenthesesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "(), 1",
            "((()()())(())), 16",
            "()()(), 3",
            "(()()()), 6",
            "(((()))), 8",
            "()(())((())()), 9"
    })
    void testScoreOfParentheses(String s, int score) {
        assertThat(underTest.scoreOfParentheses(s)).isEqualTo(score);
    }
}
