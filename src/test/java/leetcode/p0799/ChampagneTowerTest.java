package leetcode.p0799;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChampagneTowerTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 0",
            "2, 1, 1, 0.5",
            "4, 2, 0, 0.25",
            "4, 2, 1, 0.5",
            "4, 2, 2, 0.25",
            "6, 2, 0, 0.75",
            "6, 3, 0, 0",
            "6, 3, 1, 0.25",
            "6, 3, 2, 0.25",
            "6, 3, 3, 0",
            "100000009, 33, 17, 1",
            "0, 15, 4, 0"
    })
    void testChampagneTower(int poured, int query_row, int query_glass, double howFull) {
        assertThat(underTest.champagneTower(poured, query_row, query_glass))
                .isCloseTo(howFull, Percentage.withPercentage(1e-5));
    }

}
