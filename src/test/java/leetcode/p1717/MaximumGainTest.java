package leetcode.p1717;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumGainTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "cdbcbbaaabab, 4, 5, 19",
            "aabbaaxybbaabb, 5, 4, 20"
    })
    void testMaximumGain(String s, int x, int y, int score) {
        assertThat(underTest.maximumGain(s, x, y)).isEqualTo(score);
    }

}
