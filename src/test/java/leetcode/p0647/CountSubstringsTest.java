package leetcode.p0647;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountSubstringsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "abbadca, 9",
            "abbadcaabbadcaabbadcabbabbabbabbba, 67",
            "aaa, 6"
    })
    void testCountSubstrings(String s, int count) {
        assertThat(underTest.countSubstrings(s)).isEqualTo(count);
    }

}
