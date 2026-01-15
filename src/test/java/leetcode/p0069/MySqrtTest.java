package leetcode.p0069;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MySqrtTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 1",
            "4, 2",
            "5, 2",
            "14641, 121",
            "2147483646, 46340",
            "2147483647, 46340"
    })
    void testMySqrt(int x, int floorSqrt) {
        assertThat(underTest.mySqrt(x)).isEqualTo(floorSqrt);
    }

}
