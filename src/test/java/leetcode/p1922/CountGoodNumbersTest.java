package leetcode.p1922;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountGoodNumbersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5",    // 5
            "2, 20",   // 5x4
            "3, 100",  // 5x4x5
            "4, 400",  // 5x4x5x4
            "5, 2000", // 5x4x5x4x5
            "10, 3200000",
            "99999999999999, 979685745",
            "1000000000000000, 711414395"
    })
    void testCountGoodNumbers(long n, long modCount) {
        assertThat(underTest.countGoodNumbers(n)).isEqualTo(modCount);
    }
}
