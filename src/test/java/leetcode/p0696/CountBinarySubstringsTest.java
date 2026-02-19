package leetcode.p0696;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountBinarySubstringsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "00110011, 6",
            "10101, 4",
            "00001110011, 7",
            "0011110011, 6",
            "0000101010101001010111100010010101001010111111, 31",
            "00011100, 5",
            "0, 0",
            "1, 0"
    })
    void testCountBinarySubstrings(String s, int count) {
        assertThat(underTest.countBinarySubstrings(s)).isEqualTo(count);
    }

}
