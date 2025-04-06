package leetcode.p1863;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


class SubsetXORSumTest {

    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource
    void testSubsetXORSum(int[] nums, int result) {
        assertThat(v1.subsetXORSum(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testSubsetXORSum() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 6, 7, 8}, 480)
        );
    }
}
