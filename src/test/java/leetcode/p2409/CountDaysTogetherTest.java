package leetcode.p2409;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountDaysTogetherTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "08-15, 08-18, 08-16, 08-19, 3",
            "10-01, 10-31, 11-01, 12-31, 0",
            "12-31, 12-31, 01-01, 01-01, 0",
            "01-01, 06-01, 02-05, 06-02, 117",
            "02-05, 06-02, 01-01, 06-01, 117",
            "04-08, 04-30, 03-01, 05-09, 23",
            "03-01, 05-09, 03-01, 05-09, 70",
            "03-01, 03-01, 03-01, 03-01, 1"
    })
    void testCountDaysTogether(
            String arriveAlice,
            String leaveAlice,
            String arriveBob,
            String leaveBob,
            int overlappingDays
    ) {
        assertThat(underTest.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob))
                .isEqualTo(overlappingDays);
    }

}
