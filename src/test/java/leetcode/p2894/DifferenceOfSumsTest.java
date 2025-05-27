package leetcode.p2894;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DifferenceOfSumsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "5, 1, -15",
            "10, 3, 19",
            "5, 6, 15",
            "100, 6, 3418"
    })
    void testDifferenceOfSums(int n, int m, int diff) {
        assertThat(underTest.differenceOfSums(n, m)).isEqualTo(diff);
    }
}
