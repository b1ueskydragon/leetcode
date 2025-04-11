package leetcode.p2843;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountSymmetricIntegersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10000, 624",
            "999, 9999, 615"
    })
    void testCountSymmetricIntegers(int low, int high, int count) {
        assertThat(underTest.countSymmetricIntegers(low, high)).isEqualTo(count);
    }

}
