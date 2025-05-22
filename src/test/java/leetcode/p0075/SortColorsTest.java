package leetcode.p0075;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SortColorsTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    // This will modify given array `nums`
    @ParameterizedTest
    @MethodSource
    void testSortColors(int[] nums, int[] modified) {
        int[] copiedV1 = nums.clone();
        v1.sortColors(copiedV1);
        assertThat(copiedV1).isEqualTo(modified);

        int[] copiedV2 = nums.clone();
        v2.sortColors(copiedV2);
        assertThat(copiedV2).isEqualTo(modified);
    }

    static Stream<Arguments> testSortColors() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 0},
                             new int[]{0, 1, 2}),
                Arguments.of(new int[]{2, 0, 2, 1, 1, 0},
                             new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[]{1, 1, 2, 1, 1, 0, 0, 1, 1, 0, 1, 2, 2, 0, 1, 2, 2, 2, 2, 1, 1, 0, 1, 2, 2, 2, 2, 0, 2, 2, 2, 0, 0, 0, 2, 1, 0, 2, 0, 0, 2, 0, 1, 0, 2, 1, 0, 1, 0, 2, 0, 1, 1, 2, 0, 0, 0, 1, 0, 2, 2, 2, 1, 0, 1, 1, 0, 0, 2, 1, 2, 0, 1, 0, 2, 2, 2, 0, 1, 1, 1, 0, 0, 1, 0, 1, 2, 2, 1, 2, 2, 1, 0, 1, 1, 2, 2, 0, 2, 1, 2, 2, 1, 2, 2, 0, 0, 2, 0, 2, 1, 2, 2, 0, 2, 2, 2, 1, 2, 2, 0, 0, 0, 1, 2, 1, 0, 1, 2, 1, 2, 2, 2, 1, 1, 0, 1, 0, 0, 1, 1, 1, 2, 2, 0, 0, 2, 0, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0, 1, 2, 1, 2, 2, 1, 1, 0, 2, 1, 0, 1, 0, 1, 0, 1, 2, 2, 0, 1, 2, 0, 0, 1, 2, 2, 0, 1, 2, 2, 0, 0, 0, 0, 2, 2, 1, 1, 2, 1, 0, 0, 1, 0, 2, 0, 0, 2, 0, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 0, 0, 2, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 2, 1, 2, 0, 2, 1, 2, 0, 2, 0, 1, 2, 2, 0, 0, 1, 0, 2, 1, 1, 1, 0, 1, 2, 2, 2, 1, 0, 1, 1, 2, 2, 1, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 2, 1, 0, 0, 2, 0, 2, 0, 0, 1, 1, 0, 1, 1, 2, 2},
                             new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2})
        );
    }
}
