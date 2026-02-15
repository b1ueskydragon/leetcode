package leetcode.p0067.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AddBinaryTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "11, 1, 100",
            "1010, 1011, 10101",
            "1111111, 1, 10000000",
            "11101, 11100001, 11111110",
            "10100000100100110110010000010101111011011001101110111111111101000000101111001110, 10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101, 10100000100101001010010100111100101101011100011110011011001010111000101110110110010101011011011"
    })
    void testAddBinary(String a, String b, String expected) {
        assertThat(underTest.addBinary(a, b)).isEqualTo(expected);
    }

}
