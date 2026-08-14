package leetcode.p3090;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumLengthSubstringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "bcbbbcba, 4",
            "aaaa, 2",
            "aaaaaaaaaaaaaaaaaaabcbbbcba, 5",
            "abcbacbacbmwoweifj, 14",
            "aabbccddaabbccddaabbccdd, 8",
            "abcdefghijklmnopqrstuvwxyz, 26",
            "zz, 2",
            "xxxxxxxxxxxxxxxxxxxxxxxxaxxxxxxxxxx, 3"
    })
    void testMaximumLengthSubstring(String s, int maxDistance) {
        assertThat(underTest.maximumLengthSubstring(s)).isEqualTo(maxDistance);
    }
}
