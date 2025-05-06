package leetcode.p0006;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ZigZagConvertTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    // Both v2 and v1 never modify the given params
    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING, 4, PINALSIGYAHRPI",
            "PAYPALISHIRING, 5, PHASIYIRPLIGAN",
            "A, 1, A",
            "A, 1000, A",
            "AB, 2, AB"
    })
    void testConvert(String s, int numRows, String result) {
        assertThat(v2.convert(s, numRows)).isEqualTo(result);
        assertThat(v1.convert(s, numRows)).isEqualTo(result);
    }

}
