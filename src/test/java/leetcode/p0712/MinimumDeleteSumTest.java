package leetcode.p0712;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDeleteSumTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "delete, leet, 403",
            "sea, eat, 231",
            "sseeeeeeeaaaasseeeeteeee, seeeeeettttttt, 2338"
    })
    void testMinimumDeleteSum(String s1, String s2, int minSum) {
        assertThat(underTest.minimumDeleteSum(s1, s2)).isEqualTo(minSum);
    }
}
