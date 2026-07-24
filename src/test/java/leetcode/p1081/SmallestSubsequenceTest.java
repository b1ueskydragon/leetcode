package leetcode.p1081;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestSubsequenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSmallestSubsequence(String s, String subseq) {
        assertThat(underTest.smallestSubsequence(s)).isEqualTo(subseq);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        "bcabc",
                        "abc"
                ),
                Arguments.of(
                        "cbacdcbc",
                        "acdb"
                ),
                Arguments.of(
                        "zzzvnimowinoifnwoeifhoijoajiosjdoifjoidjfmzvninbboiwoqjoiwjoiejfoijoijzv",
                        "efhaiosdjmnbqwzv"
                ),
                Arguments.of(
                        "aaaa",
                        "a"
                ),
                Arguments.of(
                        "azzzvnimowinoifnwoeifhoijoajiosjdoifjoidjfmzvninbboiwoqjoiwjoiejfoijoijzvazzzvnimowinoifnwoeifhoijoajiosjdoifjoidjfmzvninbboiwoqjoiwjoiejfoijoijzvaa",
                        "abefhijosdmnqwzv"
                ),
                Arguments.of(
                        "z",
                        "z"
                ),
                Arguments.of(
                        "zyxwyutsrqponmlkjihgfedcba",
                        "zxwyutsrqponmlkjihgfedcba"
                )
        );
    }

}
