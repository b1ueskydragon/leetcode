package leetcode.p0137;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testSingleNumber(int[] nums, int theSingleElement) {
        assertThat(underTest.singleNumber(nums)).isEqualTo(theSingleElement);
    }

    static Stream<Arguments> testSingleNumber() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 2, 1, 5, 3, 2, 5, 1}, 3),
                Arguments.of(new int[]{2, -1, 5, 2, -1, 5, 0, 2, 5, -1}, 0),
                Arguments.of(new int[]{2, -1, 0, 2, -1, 0, 3, 2, 0, -1}, 3)
        );
    }
}
