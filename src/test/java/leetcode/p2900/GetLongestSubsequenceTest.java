package leetcode.p2900;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class GetLongestSubsequenceTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testGetLongestSubsequence(String[] words, int[] groups, List<String> longestSubseq) {
        assertThat(underTest.getLongestSubsequence(words, groups)).isEqualTo(longestSubseq);
    }

    static Stream<Arguments> testGetLongestSubsequence() {
        return Stream.of(
                Arguments.of(new String[]{"c"}, new int[]{0}, List.of("c")),
                Arguments.of(new String[]{"d"}, new int[]{1}, List.of("d")),
                Arguments.of(new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 1, 1}, List.of("a", "b", "c")),
                Arguments.of(new String[]{"zvedu", "lwdc", "hdzxskgolc", "riavnjtkkq", "rcjus", "lkdy", "t", "ogetdzwtp", "bxkr", "ul", "hql", "ajragiuuo", "n", "wve", "qrnsfj", "lxq", "kiiwtt", "ipaiguj", "dmp", "vgojlcy", "hl", "vhbylrhf", "utxz", "lc", "zg", "sny", "vkhd", "zwlzbzhuy", "e", "yay", "iuaz", "kulsuuksdi", "idzikb", "larthyyfrp", "tlzxb", "rxngmsw", "xyrbfmttf", "fgcehzw", "tksuk", "psngvcgjz", "alqrm", "bgfb", "fmbuv", "snprpzdees", "qlkofi", "yrdbyv", "y", "pnhxulzx", "yprndzrv", "yybcsdpivk", "xzljt", "tk", "anou", "tnzaszevuz", "iz", "cins", "lm", "g", "gap", "yrgowfrgv", "sawxnnnct", "unsaxygosz", "nsjlxxesm", "ujmav", "vj", "dam", "slnyvnzj", "eevhhnw", "gtqbbp", "krvzq", "memclrd", "gvwaaqrgz", "aigxxlhir", "vkbdo", "jazqnndx", "ttnai", "tkg", "iswjne", "scnr", "rm", "yjyr", "rvwo", "nvktima", "vwdqokabvb", "ahbmkhfim", "uvsvlvyvg", "rk", "ogqsoeywih", "v", "ccm", "fu", "crti", "bfvoapp", "d", "ayqulkg", "c", "vv", "qqkjaubnf", "pkhtth", "hdxmfxqpv"},
                             new int[]{1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0},
                             List.of("zvedu", "lwdc", "rcjus", "lkdy", "t", "ogetdzwtp", "hql", "ajragiuuo", "wve", "qrnsfj", "kiiwtt", "ipaiguj", "vgojlcy", "hl", "utxz", "sny", "zwlzbzhuy", "e", "yay", "iuaz", "fgcehzw", "psngvcgjz", "alqrm", "qlkofi", "y", "pnhxulzx", "yprndzrv", "xzljt", "tk", "tnzaszevuz", "iz", "cins", "lm", "gap", "ujmav", "vj", "slnyvnzj", "gtqbbp", "aigxxlhir", "jazqnndx", "ttnai", "scnr", "yjyr", "nvktima", "vwdqokabvb", "rk", "v", "bfvoapp", "ayqulkg", "c", "vv", "pkhtth"))
        );
    }
}
