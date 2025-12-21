package leetcode.p3573;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumProfitTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMaximumProfit(int[] prices, int k, int maxProfit) {
        assertThat(underTest.maximumProfit(prices, k)).isEqualTo(maxProfit);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 9, 8, 2}, 2, 14),
                Arguments.of(new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9}, 3, 36),
                Arguments.of(new int[]{999974280, 999994720, 999990455, 999957817, 999916154, 999998395, 999949721, 999907328, 999977094, 999911195, 999933137, 999937917, 999934494, 999921529, 999902598, 999964097, 999943603, 999903696, 999919895, 999983661, 999992067, 999910897, 999992287, 999915580, 999906625, 999957793, 999946595, 999948997, 999983819, 999920937, 999942782, 999939192, 999938685, 999960729, 999960326, 999923821, 999934884, 999944888, 999990761, 999901743, 999921794, 999961114, 999981725, 999928531, 999950599}, 22, 962628)
        );
    }
}
