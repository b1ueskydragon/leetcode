package leetcode.p2379;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumRecolorsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "WBBWWBBWBW, 7, 3",
            "WBWBBBW, 2, 0",
            "W, 1, 1",
            "B, 1 ,0",
            "WWWBWWWWWWWWWWWWWBBWBBBWWBWBBBBBBBW, 18, 5",
            "WBWBWBWBWBWBWBWBW, 5, 2",
            "BWBWBWBWBWBWBWBWB, 5, 2"
    })
    void testMinimumRecolors(String blocks, int k, int minNumOfOperation) {
        assertThat(underTest.minimumRecolors(blocks, k)).isEqualTo(minNumOfOperation);
    }
}
