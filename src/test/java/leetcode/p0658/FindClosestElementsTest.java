package leetcode.p0658;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindClosestElementsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindClosestElements(int[] arr, int k, int x, List<Integer> best) {
        assertThat(underTest.findClosestElements(arr, k, x)).isEqualTo(best);
    }

    static Stream<Arguments> testSource() {
        // 選び方次第でいろんな edge case 作れる (分布を歪ませやすい) arr.
        final int[] arr = {-1, -1, -1, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 11, 11, 111, 111, 111};
        final int evenK = 6;
        final int oddK = 7;
        return Stream.of(
                Arguments.of(arr, evenK, 3, List.of(2, 2, 2, 2, 2, 2)),
                Arguments.of(arr, evenK, 100, List.of(2, 11, 11, 111, 111, 111)),
                Arguments.of(arr, evenK, -2, List.of(-1, -1, -1, 0, 0, 0)),
                Arguments.of(arr, evenK, 112, List.of(2, 11, 11, 111, 111, 111)),
                Arguments.of(arr, evenK, 0, List.of(-1, -1, 0, 0, 0, 0)),
                Arguments.of(arr, evenK, 2, List.of(2, 2, 2, 2, 2, 2)),
                Arguments.of(arr, evenK, 1, List.of(0, 0, 0, 0, 2, 2)),
                Arguments.of(arr, evenK, -1, List.of(-1, -1, -1, 0, 0, 0)),
                Arguments.of(arr, evenK, 111, List.of(2, 11, 11, 111, 111, 111)),
                Arguments.of(arr, oddK, 1, List.of(0, 0, 0, 0, 2, 2, 2)),
                Arguments.of(arr, oddK, 12, List.of(2, 2, 2, 2, 2, 11, 11))
        );
    }

}
