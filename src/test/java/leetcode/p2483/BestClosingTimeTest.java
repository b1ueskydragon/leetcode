package leetcode.p2483;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BestClosingTimeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "YYNY, 2",
            "NNNNN, 0",
            "YYYY, 4",
            "YNYNYN, 1",
            "NYNYNY, 0",
            "NYNYNYN, 0",
            "YNYNYNY, 1",
            "YYYYYYNNYYYYYYNNNNNYYYYYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYYNYYYYNNNNNNNNNNNNNNNNYYYYYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYYYYYYNNNNNNNNNNNNNNNNYYYYYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYYYYYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY, 25"
    })
    void testBestClosingTime(String customers, int earliest) {
        assertThat(underTest.bestClosingTime(customers)).isEqualTo(earliest);
    }

}
