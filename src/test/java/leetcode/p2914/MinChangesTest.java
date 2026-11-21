package leetcode.p2914;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinChangesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "100011, 1",
            "100111, 2",
            "1001, 2",
            "01110101111111111111111111111111111000, 4",
            "1111111111111111, 0",
            "000000000000000000, 0",
            "101010101010101001010101010101011100110011100000110011, 17"
    })
    void testMinChanges(String s, int minChanges) {
        assertThat(underTest.minChanges(s)).isEqualTo(minChanges);
    }

}
