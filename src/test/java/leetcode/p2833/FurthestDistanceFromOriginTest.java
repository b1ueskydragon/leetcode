package leetcode.p2833;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FurthestDistanceFromOriginTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "L_RL__R, 3",
            "LLRR___, 3",
            "_R__LL_, 5",
            "_______, 7"
    })
    void testFurthestDistanceFromOrigin(String moves) {
        assertThat(underTest.furthestDistanceFromOrigin(moves));
    }

}
