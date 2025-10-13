package leetcode.p2273;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveAnagramsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void removeAnagrams(String[] words, List<String> expected) {
        assertThat(underTest.removeAnagrams(words)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new String[]{"abba", "baba", "bbaa", "cd", "cd"}, List.of("abba", "cd")),
                Arguments.of(new String[]{"abba", "bbaa", "cd", "cd", "baba"}, List.of("abba", "cd", "baba")),
                Arguments.of(new String[]{"a", "aa", "aaa", "aaaa"}, List.of("a", "aa", "aaa", "aaaa")),
                Arguments.of(new String[]{"a", "a", "a", "a"}, List.of("a"))
        );
    }

}
