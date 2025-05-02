package leetcode.p0006;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ZigZagConvertTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING, 4, PINALSIGYAHRPI",
            "PAYPALISHIRING, 5, PHASIYIRPLIGAN",
            "A, 1, A",
            "A, 1000, A",
            "AB, 2, AB"
    })
    void testConvert(String s, int numRows, String result) {
        assertThat(underTest.convert(s, numRows)).isEqualTo(result);
    }

}
