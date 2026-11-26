package leetcode.p3360;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CanAliceWinTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, false",
            "3, false",
            "4, false",
            "5, false",
            "6, false",
            "7, false",
            "8, false",
            "9, false",
            "10, true",
            "11, true",
            "12, true",
            "13, true",
            "14, true",
            "15, true",
            "16, true",
            "17, true",
            "18, true",
            "19, false",
            "20, false",
            "21, false",
            "22, false",
            "23, false",
            "24, false",
            "25, false",
            "26, false",
            "27, true",
            "28, true",
            "29, true",
            "30, true",
            "31, true",
            "32, true",
            "33, true",
            "34, false",
            "35, false",
            "36, false",
            "37, false",
            "38, false",
            "39, false",
            "40, true",
            "41, true",
            "42, true",
            "43, true",
            "44, true",
            "45, false",
            "46, false",
            "47, false",
            "48, false",
            "49, true",
            "50, true"
    })
    void testCanAliceWin(int n, boolean expected) {
        assertThat(underTest.canAliceWin(n)).isEqualTo(expected);
    }

}
