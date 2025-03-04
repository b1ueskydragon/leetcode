package leetcode.p1780;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CheckPowersOfThreeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "12, true",
            "91, true",
            "21, false",
            "2, false",
            "10000000, false",
            "1, true",
            "3, true",
            "9, true",
            "3333333, false"
    })
    void testCheckPowersOfThree(int n, boolean isASumOfPowersOfThree) {
        assertThat(underTest.checkPowersOfThree(n)).isEqualTo(isASumOfPowersOfThree);
    }

}
