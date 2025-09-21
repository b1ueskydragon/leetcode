package leetcode.p2353;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodRatingsTest {

    @Test
    void testCase1() {
        final var underTest = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );
        assertThat(underTest.highestRated("korean")).isEqualTo("kimchi");
        assertThat(underTest.highestRated("japanese")).isEqualTo("ramen");
        underTest.changeRating("sushi", 16); // ranked up
        assertThat(underTest.highestRated("japanese")).isEqualTo("sushi");
        underTest.changeRating("ramen", 16); // ranked up
        assertThat(underTest.highestRated("japanese")).isEqualTo("ramen"); // choose lexicographically smaller one
    }

    @Test
    void testCase2() {
        final var underTest = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 6, 8, 15, 14, 7}
        );
        assertThat(underTest.highestRated("korean")).isEqualTo("kimchi");
        assertThat(underTest.highestRated("japanese")).isEqualTo("ramen");
        underTest.changeRating("sushi", 6); // ranked down
        assertThat(underTest.highestRated("japanese")).isEqualTo("ramen");
        underTest.changeRating("ramen", 6); // ranked down
        assertThat(underTest.highestRated("japanese")).isEqualTo("miso");
    }

}
