package leetcode.p1689;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinPartitionsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "32, 3",
            "82734, 8",
            "27346209830709182346, 9"
    })
    void testMinPartitions(String n, int expected) {
        assertThat(underTest.minPartitions(n)).isEqualTo(expected);
    }

}
