package leetcode.p3541;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxFreqSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "successes, 6",
            "aeiaeia, 3",
            "llleeeeeeeetcccoooooodddddeeee, 17",
            "abcd, 2",
            "abcde, 2",
            "aeiou, 1",
            "rbbrdck, 2"
    })
    void testMaxFreqSum(String s, int expected) {
        assertThat(underTest.maxFreqSum(s)).isEqualTo(expected);
    }

}
