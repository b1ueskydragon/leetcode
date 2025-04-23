package leetcode.p1399.s2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountLargestGroupTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "13, 4",
            "14, 5",
            "989, 2",
            "10000, 1"
    })
    void testCountLargestGroup(int n, int count) {
        assertThat(underTest.countLargestGroup(n)).isEqualTo(count);
    }

}
