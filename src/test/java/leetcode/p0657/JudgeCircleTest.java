package leetcode.p0657;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeCircleTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "UD, true",
            "LL, false"
    })
    void testJudgeCircle(String moves, boolean expected) {
        assertThat(underTest.judgeCircle(moves)).isEqualTo(expected);
    }

}
