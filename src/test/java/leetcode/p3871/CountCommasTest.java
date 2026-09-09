package leetcode.p3871;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountCommasTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "1002, 3",
            "998, 0",
            "99999999999, 298998999000",
            "999999, 999000",
            "1000000000000000, 3998998998999005",
            "999999999, 1998999000",
            "19021905701962, 75086621806852",
            "999999999999999, 3998998998999000",
            "12897592878, 37691777637",
            "213498193279, 639493578840",
            "23482397, 45963796",
            "121890, 120891",
            "51230591203, 152690772612",
    })
    void testCountCommas(long n, long count) {
        assertThat(underTest.countCommas(n)).isEqualTo(count);
    }

}
