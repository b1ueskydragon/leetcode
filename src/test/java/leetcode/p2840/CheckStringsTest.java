package leetcode.p2840;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CheckStringsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "abcdba, cabdab, true" ,
            "abe, bea, false" ,
            "baaaaaaaaaaaaa, aaaaaaaaaaaaab, false" ,
            "baaaaaaaaaaaaa ,aaaaaaaaaaaaba, true" ,
            "xyzxyzxyzyxyzyxzyxyzy, yxzxxzxxzyyyzyxzyyyzy, false" ,
            "abc, xyz, false" ,
            "abcedfgabcedfgabcedfgabcedfgabcedfgabcedfg, gfdecbagfdecbagfdecbagfdecbagfdecbagfdecba, true"
    })
    void testCheckStrings(String s1, String s2, boolean expected) {
        assertThat(underTest.checkStrings(s1, s2)).isEqualTo(expected);
    }
}
