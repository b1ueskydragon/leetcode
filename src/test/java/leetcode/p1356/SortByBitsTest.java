package leetcode.p1356;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortByBitsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testSortByBits(int[] arr, int[] expected) {
        assertThat(underTest.sortByBits(arr)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}),
                Arguments.of(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}, new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9488, 9999, 10000}, new int[]{0, 1, 2, 4, 8, 3, 5, 6, 9, 10, 7, 9488, 10000, 9999})
        );
    }

}
