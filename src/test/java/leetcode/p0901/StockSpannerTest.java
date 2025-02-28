package leetcode.p0901;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class StockSpannerTest {

    private StockSpanner instance;

    @BeforeEach
    void setUp() {
        instance = new StockSpanner();
    }

    @ParameterizedTest
    @MethodSource
    void testStockSpanner(int[] prices, int[] expected) {
        final int[] span = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            span[i] = instance.next(prices[i]);
        }
        assertThat(span).isEqualTo(expected);
    }

    static Stream<Arguments> testStockSpanner() {
        return Stream.of(
                Arguments.of(new int[]{100, 80, 60, 70, 60, 75, 85}, new int[]{1, 1, 1, 2, 1, 4, 6}),
                Arguments.of(new int[]{7, 2, 1, 2}, new int[]{1, 1, 1, 3}),
                // equivalent values
                Arguments.of(new int[]{2, 2, 2, 2}, new int[]{1, 2, 3, 4}),
                // ascending
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6, 7}),
                // descending
                Arguments.of(new int[]{7, 6, 5, 4, 3, 2, 1}, new int[]{1, 1, 1, 1, 1, 1, 1})
        );
    }
}
