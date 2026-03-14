package leetcode.p1415.s2026;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GetHappyStringTest {
    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, c",
            "1, 4, ''",
            "3, 9, cab",
            "10, 100, abacbabacb",
            "10, 44, ababcacacb",
            "8, 23, abacacba",
            "1, 1, a",
            "1, 100, ''"
    })
    void testGetHappyString(int n, int k, String expected) {
        assertThat(underTest.getHappyString(n, k)).isEqualTo(expected);
    }
}
