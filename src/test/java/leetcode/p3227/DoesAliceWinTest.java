package leetcode.p3227;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DoesAliceWinTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "leetcoder, true",
            "bbcd, false",
            "leeeeeetcodeeeee, true",
            "leeeeeetcodeeeeee, true",
            "leeeeeetcodeeeeed, true",
            "leeeeeetcodeeeeede, true",
            "k, false",
            "a, true"
    })
    void testDoesAliceWin(String s, boolean expected) {
        assertThat(underTest.doesAliceWin(s)).isEqualTo(expected);
    }

}
