package leetcode.p3622;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class CheckDivisibilityTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "99, true",
            "23, false",
            "19058, false",
            "1000000, true",
            "999999, false",
            "1, false",
            "104951, false"
    })
    void testCheckDivisibility(int n, boolean expected) {
        assertThat(underTest.checkDivisibility(n)).isEqualTo(expected);
    }

}
