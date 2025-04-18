package leetcode.p0038.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountAndSayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 11",
            "3, 21",
            "4, 1211",
            "10, 13211311123113112211"
    })
    void testCountAndSay(int n, String nThStr) {
        assertThat(underTest.countAndSay(n)).isEqualTo(nThStr);
    }
}
