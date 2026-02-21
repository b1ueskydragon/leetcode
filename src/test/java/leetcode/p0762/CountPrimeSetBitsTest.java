package leetcode.p0762;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountPrimeSetBitsTest {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "6, 10, 4",
            "10, 15, 5",
            "1, 10000, 4252",
            "999000, 1000000, 272",
            "2643, 6782, 1718"
    })
    void testCountPrimeSetBits(int left, int right, int expected) {
        assertThat(underTest.countPrimeSetBits(left, right)).isEqualTo(expected);
    }

}
