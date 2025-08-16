package leetcode.p0342;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsPowerOfFourTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "16, true",
            "5, false",
            "1, true",
            "0, false",
            "8, false",
            "96, false",
            "64, true",
            "1073741824, true",
            "268435456, true"
    })
    void testIsPowerOfFour(int n, boolean expected) {
        assertThat(underTest.isPowerOfFour(n)).isEqualTo(expected);
    }

}
