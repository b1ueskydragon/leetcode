package leetcode.p2401;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LongestNiceSubarrayTest {

    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource
    void testLongestNiceSubarray(int[] nums, int theLongestDistance) {
        assertThat(v1.longestNiceSubarray(nums)).isEqualTo(theLongestDistance);
    }

    static Stream<Arguments> testLongestNiceSubarray() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 8, 48, 10}, 3),
                Arguments.of(new int[]{10, 8, 3, 8, 3, 2, 3, 8, 3}, 2),
                Arguments.of(new int[]{1, 5, 2, 8, 3, 10}, 3),
                Arguments.of(new int[]{
                        84139415, 693324769, 614626365, 497710833, 615598711,
                        264, 65552, 50331652, 1, 1048576,
                        16384, 544, 270532608, 151813349, 221976871,
                        678178917, 845710321, 751376227, 331656525, 739558112,
                        267703680}, 8)
        );
    }
}
