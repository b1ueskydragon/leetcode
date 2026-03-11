package leetcode.p1009;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BitwiseComplementTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "23, 8", // 10111, 01000
            "0, 1", // Edge case
            "5, 2",
            "7, 0",
            "10, 5",
            "1, 0",
            "1000000000, 73741823",
            "999999999, 73741824"
    })
    void testBitwiseComplement(int n, int complement) {
        assertThat(underTest.bitwiseComplement(n)).isEqualTo(complement);
    }

}
