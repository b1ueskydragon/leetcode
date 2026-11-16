package leetcode.p2243;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DigitSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "11111222223, 3, 135",
            "00000000, 3, 000",
            "9999999999991991919191919192919291291921291291921, 2, 46",
            "9999999999991991919191919192919291291921291291921, 6, 211213",
            "9999999999991991919191919192919291291921291291921, 9, 4510",
            "9999999999991991919191919192919291291921291291921, 60, 9999999999991991919191919192919291291921291291921",
            "999999999999999988889989899899999999999999999998888998989989999999999999999999888899898998999, 31, 272272272",
            "10, 2, 10",
            "46, 2, 46"
    })
    void testDigitSum(String s, int k, String expected) {
        assertThat(underTest.digitSum(s, k)).isEqualTo(expected);
    }

}
