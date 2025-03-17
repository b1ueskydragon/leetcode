package leetcode.p2206;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DivideArrayTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    // Both v1 and v2 never modify the given array `nums`
    @ParameterizedTest
    @MethodSource
    void testDivideArray(int[] nums, boolean result) {
        assertThat(v1.divideArray(nums)).isEqualTo(result);
        assertThat(v2.divideArray(nums)).isEqualTo(result);
    }

    static Stream<Arguments> testDivideArray() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3, 2, 2, 2}, true),
                Arguments.of(new int[]{500, 500, 499, 498}, false),
                Arguments.of(new int[]{500, 500, 499, 499}, true)
        );
    }
}
