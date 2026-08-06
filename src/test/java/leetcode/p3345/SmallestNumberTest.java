package leetcode.p3345;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestNumberTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2, 4",
            "1, 10, 10",
            "44, 7, 47",
            "99, 7, 100"
    })
    void testSmallestNumber(int n, int t, int expected) {
        assertThat(underTest.smallestNumber(n, t)).isEqualTo(expected);
    }

}
