package leetcode.p1437;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KLengthApartTest {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testKLengthApart(int[] nums, int k, boolean expected) {
        assertThat(underTest.kLengthApart(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2, true),
                Arguments.of(new int[]{1, 0, 0, 1, 0, 1}, 2, false),
                Arguments.of(new int[]{0, 1, 0, 0, 1, 0, 0, 1}, 2, true),
                Arguments.of(new int[]{0, 0, 0}, 2, true)
        );
    }

}
