package leetcode.p1545;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindKthBitTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "4, 1, 0",
            "4, 2, 1",
            "4, 3, 1",
            "4, 4, 1",
            "4, 5, 0",
            "4, 6, 0",
            "4, 7, 1",
            "4, 8, 1",
            "4, 9, 0",
            "4, 10, 1",
            "4, 11, 1",
            "4, 12, 0",
            "4, 13, 0",
            "4, 14, 0",
            "4, 15, 1",
            "20, 5555, 1"
    })
    void testFindKthBit(int n, int k, char kthBit) {
        assertThat(underTest.findKthBit(n, k)).isEqualTo(kthBit);
    }

}
