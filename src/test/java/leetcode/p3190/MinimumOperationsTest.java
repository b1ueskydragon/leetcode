package leetcode.p3190;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumOperationsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void minimumOperations(int[] nums, int expected) {
        assertThat(underTest.minimumOperations(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 3),
                Arguments.of(new int[]{3, 6, 9}, 0),
                Arguments.of(new int[]{9, 33, 8, 33, 7, 11, 39, 32, 39, 11, 22, 32, 30, 5, 29, 45, 47, 27, 32, 17, 19, 43, 25, 44, 10, 30, 20, 32, 4, 34, 50, 29, 36, 10, 46, 5, 36, 2, 42, 5, 32, 31, 16, 23, 34, 49, 38, 26, 40, 11}, 38)
        );
    }

}
