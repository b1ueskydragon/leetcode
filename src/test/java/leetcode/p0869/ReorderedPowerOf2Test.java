package leetcode.p0869;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class ReorderedPowerOf2Test {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "10, false",
            "2401, true",
            "536870921, true",
            "1000000000, false"
    })
    void reorderedPowerOf2(int n, boolean expected) {
        assertThat(underTest.reorderedPowerOf2(n)).isEqualTo(expected);
    }

}
