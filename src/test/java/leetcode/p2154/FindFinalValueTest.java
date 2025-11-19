package leetcode.p2154;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindFinalValueTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int[] nums, int original, int missing) {
        assertThat(v2.findFinalValue(nums, original)).isEqualTo(missing);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int[] nums, int original, int missing) {
        assertThat(v1.findFinalValue(nums, original)).isEqualTo(missing);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 6, 1, 12}, 3, 24),
                Arguments.of(new int[]{6, 7, 11, 36, 5, 3, 48, 13, 12, 54}, 3, 24),
                Arguments.of(new int[]{6, 6, 6, 6, 6, 6, 7, 11, 36, 5, 3, 48, 13, 12, 54}, 3, 24),
                Arguments.of(new int[]{1000, 500, 250}, 1000, 2000),
                Arguments.of(new int[]{12, 3, 6, 24, 48}, 12, 96)
        );
    }

}
