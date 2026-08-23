package leetcode.p3069;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultArrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testResultArray(int[] nums, int[] expected) {
        assertThat(underTest.resultArray(nums)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 33, 4, 37, 36, 7, 39, 44, 15, 16, 18, 21, 23, 24, 26, 28, 30, 31},
                        new int[]{1, 33, 4, 37, 36, 7, 39, 44, 15, 16, 18, 21, 23, 24, 26, 28, 30, 31}
                )
        );
    }

}
