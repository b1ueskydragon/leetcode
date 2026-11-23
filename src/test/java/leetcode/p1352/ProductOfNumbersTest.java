package leetcode.p1352;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOfNumbersTest {

    // The original Test case:
    // ["ProductOfNumbers","add","add","add","add","add","add","getProduct","add","add",
    // "getProduct","add","getProduct","add","add","getProduct","getProduct","getProduct",
    // "getProduct","getProduct","getProduct","getProduct","getProduct","getProduct","getProduct",
    // "getProduct","getProduct"]
    // [[],[0],[4],[0],[1],[4],[9],[2],[0],[3],[3],[3],[2],[6],[1],[5],[10],[9],[7],[8],[6],[5],[4],[3],[2],[1],[11]]
    @Test
    void shouldAddAndGetProduct() {
        final var underTest = new ProductOfNumbers();
        underTest.add(0);
        underTest.add(4);
        underTest.add(0);
        underTest.add(1);
        underTest.add(4);
        underTest.add(9);
        assertThat(underTest.getProduct(2)).isEqualTo(36);
        underTest.add(0);
        underTest.add(3);
        assertThat(underTest.getProduct(3)).isEqualTo(0);
        underTest.add(3);
        assertThat(underTest.getProduct(2)).isEqualTo(9);
        underTest.add(6);
        underTest.add(1);
        assertThat(underTest.getProduct(5)).isEqualTo(0);
        assertThat(underTest.getProduct(10)).isEqualTo(0);
        assertThat(underTest.getProduct(9)).isEqualTo(0);
        assertThat(underTest.getProduct(7)).isEqualTo(0);
        assertThat(underTest.getProduct(8)).isEqualTo(0);
        assertThat(underTest.getProduct(6)).isEqualTo(0);
        assertThat(underTest.getProduct(5)).isEqualTo(0);
        assertThat(underTest.getProduct(4)).isEqualTo(54);
        assertThat(underTest.getProduct(3)).isEqualTo(18);
        assertThat(underTest.getProduct(2)).isEqualTo(6);
        assertThat(underTest.getProduct(1)).isEqualTo(1);
        assertThat(underTest.getProduct(11)).isEqualTo(0);
    }

}
