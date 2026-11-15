package leetcode.p1524;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumOfSubarraysTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNumOfSubarrays(int[] arr, int oddSubarrays) {
        assertThat(underTest.numOfSubarrays(arr)).isEqualTo(oddSubarrays);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5, 8}, 8),
                Arguments.of(new int[]{1, 3, 5}, 4),
                Arguments.of(new int[]{2, 4, 6}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 16)
        );
    }

}
