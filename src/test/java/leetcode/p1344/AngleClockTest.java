package leetcode.p1344;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AngleClockTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4, 8.0",
            "1, 57, 76.5",
            "12, 0, 0.0",
            "9, 41, 44.5",
            "12, 30, 165.0",
            "3, 30, 75.0",
            "3, 15, 7.5",
            "9, 21, 154.5",
            "11, 11, 90.5",
            "11, 0, 30.0",
            "6, 0, 180.0",
            "6, 1, 174.5"
    })
    void testAngleClock(int hour, int minutes, double expectedAngle) {
        assertThat(underTest.angleClock(hour, minutes)).isEqualTo(expectedAngle);
    }
}
