package leetcode.p0033;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchTest {

    private Solution s2021;
    private Solution s2026;

    @BeforeEach
    void setUp() {
        s2021 = new Solution2021();
        s2026 = new Solution2026();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2021(int[] nums, int target, int index) {
        assertThat(s2021.search(nums, target)).isEqualTo(index);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testS2026(int[] nums, int target, int index) {
        assertThat(s2026.search(nums, target)).isEqualTo(index);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 6, 7}, 5, -1),
                Arguments.of(new int[]{6, 7, 0, 1, 2, 4, 5}, 0, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 6, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 3, 7),
                Arguments.of(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 11, -1),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 7, 1),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 1, 2),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 2, 3),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 3, 4),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 4, 5),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 5, 6),
                Arguments.of(new int[]{6, 7, 1, 2, 3, 4, 5}, 8, -1),
                Arguments.of(new int[]{6, 7, 1, 2, 4, 5}, 6, 0),
                Arguments.of(new int[]{6, 7, 1, 3, 4, 5}, 7, 1),
                Arguments.of(new int[]{6, 7, 1, 2, 4, 5}, 1, 2),
                Arguments.of(new int[]{6, 7, 1, 3, 4, 5}, 2, -1),
                Arguments.of(new int[]{6, 7, 2, 3, 4, 5}, 3, 3),
                Arguments.of(new int[]{6, 7, 2, 3, 4, 5}, 4, 4),
                Arguments.of(new int[]{6, 7, 2, 3, 4, 5}, 5, 5),
                Arguments.of(new int[]{6, 1, 2, 3, 4, 5}, 8, -1),
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{3, 1}, 3, 0),
                Arguments.of(new int[]{3, 1}, 0, -1)
        );
    }

}
