package leetcode.p3904;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstStableIndexTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFirstStableIndex(int[] nums, int k, int expected) {
        assertThat(underTest.firstStableIndex(nums, k)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{5, 0, 1, 4}, 3, 3),
                Arguments.of(new int[]{3, 2, 1}, 1, -1),
                Arguments.of(new int[]{0}, 0, 0)
        );
    }

}
