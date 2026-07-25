package leetcode.p3536;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProductTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "31, 3",
            "22, 4",
            "124, 8",
            "109929810, 81",
            "10, 0",
            "1100, 1",
            "988, 72",
            "9777, 63"
    })
    void testMaxProduct(int n, int maxProduct) {
        assertThat(underTest.maxProduct(n)).isEqualTo(maxProduct);
    }

}
