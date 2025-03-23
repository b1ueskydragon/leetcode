package leetcode.p2115;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllRecipesTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testFindAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies, List<String> expected) {
        assertThat(underTest.findAllRecipes(recipes, ingredients, supplies))
                .isEqualTo(expected);
    }

    static Stream<Arguments> testFindAllRecipes() {
        return Stream.of(
                Arguments.of(new String[]{"bread", "sandwich", "burger", "bigburger"},
                             List.of(List.of("yeast", "flour"),
                                     List.of("bread", "meat"),
                                     List.of("sandwich", "meat", "bread"),
                                     List.of("burger", "bread")),
                             new String[]{"yeast", "flour", "meat"},
                             List.of("bread", "sandwich", "burger", "bigburger")),
                Arguments.of(new String[]{"ju", "fzjnm", "x", "e", "zpmcz", "h", "q"},
                             List.of(List.of("d"), List.of("hveml", "f", "cpivl"),
                                     List.of("cpivl", "zpmcz", "h", "e", "fzjnm", "ju"),
                                     List.of("cpivl", "hveml", "zpmcz", "ju", "h"),
                                     List.of("h", "fzjnm", "e", "q", "x"),
                                     List.of("d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x"),
                                     List.of("f", "hveml", "cpivl")),
                             new String[]{"f", "hveml", "cpivl", "d"},
                             List.of("ju", "fzjnm", "q"))
        );
    }
}
