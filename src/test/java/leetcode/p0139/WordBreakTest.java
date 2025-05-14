package leetcode.p0139;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordBreakTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testWordBreak(String s, List<String> wordDict, boolean result) {
        assertThat(underTest.wordBreak(s, wordDict)).isEqualTo(result);
    }

    static Stream<Arguments> testWordBreak() {
        return Stream.of(
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                // section の重複は許されない
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false),
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("leetcode", List.of("leet", "code", "e", "leetcode", "leeeetcode"), true),
                // 構成さえできれば関係ない単語が混ざっても OK
                Arguments.of("leetcode", List.of("lee", "tco", "de", "apple"), true),
                // 最初の "a" の時点で invalid
                Arguments.of("aleetcode", List.of("leet", "code"), false),
                Arguments.of("l", List.of("l"), true)
        );
    }

}
