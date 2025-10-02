package leetcode.p3100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxBottlesDrunkTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "13, 6, 15",
            "10, 3, 13",
            "13, 13, 14",
            "1, 100, 1",
            "100, 1, 114",
            "91, 11, 97",
            "11, 91, 11"
    })
    void maxBottles(int numBottles, int numExchange, int expected) {
        assertThat(underTest.maxBottlesDrunk(numBottles, numExchange)).isEqualTo(expected);
    }

}
