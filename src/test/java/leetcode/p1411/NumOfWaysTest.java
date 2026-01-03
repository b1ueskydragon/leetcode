package leetcode.p1411;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumOfWaysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 12",
            "2, 54",
            "3, 246",
            "4, 1122",
            "5, 5118",
            "4999, 134620719",
            "5000, 30228214"
    })
    void testNumOfWays(int n, int possibleWays) {
        assertThat(underTest.numOfWays(n)).isEqualTo(possibleWays);
    }

}
