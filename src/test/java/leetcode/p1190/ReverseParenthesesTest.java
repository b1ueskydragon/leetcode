package leetcode.p1190;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseParenthesesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testReverseParentheses(String s, String expected) {
        assertThat(underTest.reverseParentheses(s)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "(abcd)",
                        "dcba"
                ),
                Arguments.of(
                        "(u(love)i)",
                        "iloveu"
                ),
                Arguments.of(
                        "(ed(et(oc))el)",
                        "leetcode"
                ),
                Arguments.of(
                        "(ab(c)def(gh)ij(klmnop)q(r(s))tuv)wxyz",
                        "vutrsqklmnopjighfedcbawxyz"
                ),
                Arguments.of(
                        "()(())",
                        ""
                )
        );
    }

}
