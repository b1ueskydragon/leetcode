package leetcode.p0326;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsPowerOfThreeTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "0, false",
            "1, true",
            "-1, false",
            "6, false",
            "27, true",
            "2147483647, false",
            "1162261467, true"
    })
    void testIsPowerOfThree(int n, boolean expected) {
        assertThat(underTest.isPowerOfThree(n)).isEqualTo(expected);
    }

}
