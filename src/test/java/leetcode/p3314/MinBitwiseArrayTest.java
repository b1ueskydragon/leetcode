package leetcode.p3314;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinBitwiseArrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testMinBitwiseArray(List<Integer> nums, int[] expected) {
        assertThat(underTest.minBitwiseArray(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31), new int[]{-1, 1, 4, 3, 9, 12, 16, 17, 19, 28, 15}),
                Arguments.of(List.of(149, 521, 71, 967, 449, 101, 439, 557, 73, 179), new int[]{148, 520, 67, 963, 448, 100, 435, 556, 72, 177})
        );
    }

}
