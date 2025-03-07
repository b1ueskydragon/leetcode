package leetcode.p2523;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ClosestPrimesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "10, 19, 11, 13",
            "4, 6, -1, -1",
            "13, 19, 17, 19",
            "1, 1000000, 2, 3",
            "900091, 1000000, 900329, 900331",
            "900089, 900091, 900089, 900091"
    })
    void testClosestPrimes(int left, int right, int a, int b) {
        assertThat(underTest.closestPrimes(left, right)).isEqualTo(new int[]{a, b});
    }
}
