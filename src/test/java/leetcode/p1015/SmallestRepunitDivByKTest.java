package leetcode.p1015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestRepunitDivByKTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, -1",
            "3, 3",
            "4, -1",
            "5, -1",
            "7 , 6",
            "9999, 36",
            "7863, 7860"
    })
    void testSmallestRepunitDivByK(int k, int expected) {
        assertThat(underTest.smallestRepunitDivByK(k)).isEqualTo(expected);
    }

}
