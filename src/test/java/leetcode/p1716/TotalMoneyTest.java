package leetcode.p1716;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TotalMoneyTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "20, 96",
            "1, 1",
            "1000, 74926",
            "98, 1029",
            "999, 74778",
            "4, 10",
            "10, 37"
    })
    void testTotalMoney(int n, int expected) {
        assertThat(underTest.totalMoney(n)).isEqualTo(expected);
    }

}
