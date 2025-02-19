package leetcode.p1415;

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
            "1, 3 ,c",
            "1, 4, ''",
            "3, 9, cab",
            "2, 2, ac",
            "10, 100, abacbabacb",
            "1, 100, ''",
            "10, 1, ababababab"
    })
    void testGetHappyString(int n, int k, String expected) {
        assertThat(underTest.getHappyString(n, k)).isEqualTo(expected);
    }
}
