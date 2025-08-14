package leetcode.p0326;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsPowerOfThreeTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
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
    void testV2(int n, boolean expected) {
        assertThat(v2.isPowerOfThree(n)).isEqualTo(expected);
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
    void testV1(int n, boolean expected) {
        assertThat(v1.isPowerOfThree(n)).isEqualTo(expected);
    }

}
