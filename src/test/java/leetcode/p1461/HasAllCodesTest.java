package leetcode.p1461;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class HasAllCodesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "00110110, 2, true",
            "0110, 1, true",
            "0, 20, false",
            "000001010011100101110111, 3, true",
            "00001010011100101110111, 3, true",
            "10100111001011101110001, 3, true"
    })
    void testHasAllCodes(String s, int k, boolean expected) {
        assertThat(underTest.hasAllCodes(s, k)).isEqualTo(expected);
    }

}
