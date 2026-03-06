package leetcode.p0003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfLongestSubstringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testLengthOfLongestSubstring(String s, int longestSubStrLenWithoutRepeats) {
        assertThat(underTest.lengthOfLongestSubstring(s)).isEqualTo(longestSubStrLenWithoutRepeats);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of(" ", 1),
                Arguments.of("au", 2),
                Arguments.of("tmmzuxt", 5),
                Arguments.of("dvdf", 3),
                Arguments.of("snzAxcmv,mhnwoiwt oij.,mzviopjAldskjfwionvo138u5293846qn kzjnvzxlkcvjoi10293848676d859 48 939020586ianv8vuq23908tyoauhvzbx 9289 34q0", 17)
        );
    }
}
