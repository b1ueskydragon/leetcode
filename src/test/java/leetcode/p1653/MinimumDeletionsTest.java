package leetcode.p1653;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDeletionsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @CsvSource({
            "aababbab, 2",
            "aaba, 1",
            "aabab, 1",
            "bbaaaaabb, 2",
            "a, 0",
            "b, 0",
            "bba, 1",
            "ababba, 2",
            "aaabababbbbbbbaababbabbbbbbbbbbaababbabbaaabababbbbbbbaababbabbbbbbbbbbaababbabbbaaaaababababababbbaaaabbaaaaaaababaaaaababababababbbaaaabbaaaaaaabaaaabababbbbbbbaababbabbbbbbbbbbaababbabbbaaaaababababababbbaaaabbaaaaaaaba, 102"
    })
    void testMinimumDeletions(String s, int minDeletions) {
        assertThat(underTest.minimumDeletions(s)).isEqualTo(minDeletions);
    }

}
