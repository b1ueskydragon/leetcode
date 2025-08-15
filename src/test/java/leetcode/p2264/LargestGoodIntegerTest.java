package leetcode.p2264;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LargestGoodIntegerTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "6777133339, 777",
            "2300019, 000",
            "67771333399677713333996777133339967771333398889, 888",
            "42352338, ''"
    })
    void testLargestGoodInteger(String num, String expected) {
        assertThat(underTest.largestGoodInteger(num)).isEqualTo(expected);
    }

}
