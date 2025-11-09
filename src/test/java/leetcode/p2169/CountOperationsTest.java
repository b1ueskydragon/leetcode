package leetcode.p2169;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 3",
            "10, 10, 1",
            "0, 0, 0",
            "100000, 0, 0",
            "100000, 100000, 1",
            "0, 100000, 0",
            "45794, 9752, 28",
            "1, 99999, 99999"
    })
    void testCountOperations(int num1, int num2, int expected) {
        assertThat(underTest.countOperations(num1, num2)).isEqualTo(expected);
    }

}
