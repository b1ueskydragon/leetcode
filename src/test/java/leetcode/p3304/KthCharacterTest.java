package leetcode.p3304;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class KthCharacterTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1, a",
            "9, b",
            "111, f",
            "499, g",
            "500, h"
    })
    void testKthCharacter(int k, char kTh) {
        assertThat(underTest.kthCharacter(k)).isEqualTo(kTh);
    }

}
