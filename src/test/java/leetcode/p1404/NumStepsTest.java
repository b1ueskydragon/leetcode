package leetcode.p1404;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumStepsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "10, 1",
            "11, 3",
            "10011, 8",
            "1000, 3",
            "1111111011111111, 18",
            "1, 0"
    })
    void testNumSteps(String s, int operations) {
        assertThat(underTest.numSteps(s)).isEqualTo(operations);
    }
}
