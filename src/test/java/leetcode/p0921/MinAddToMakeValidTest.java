package leetcode.p0921;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinAddToMakeValidTest {

    private Solution2026 underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution2026();
    }

    @ParameterizedTest
    @CsvSource({
            "()), 1",
            "(((, 3",
            "(), 0",
            "()))((, 4",
            "()(), 0",
            "))(), 2",
            "(()))))(, 4",
            ")(((())))()())))))()((()))))))(())))()()()())(()))()(, 15"
    })
    void testMinAddToMakeValid(String s, int minToAdd) {
        assertThat(underTest.minAddToMakeValid(s)).isEqualTo(minToAdd);
    }
}
