package leetcode.p3516;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindClosestTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 7, 4, 1",
            "2, 5, 6, 2",
            "1, 5, 3, 0"
    })
    void findClosest(int x, int y, int z, int expected) {
        assertThat(v2.findClosest(x, y, z)).isEqualTo(expected);
        assertThat(v1.findClosest(x, y, z)).isEqualTo(expected);
    }

}
