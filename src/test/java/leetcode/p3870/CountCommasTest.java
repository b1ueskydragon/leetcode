package leetcode.p3870;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountCommasTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "10, 0",
            "100, 0",
            "1_000, 1",
            "10_000, 9001",
            "100_000, 99001",
    })
    void testCountCommas(int n, int count) {
        assertThat(underTest.countCommas(n)).isEqualTo(count);
    }
}
