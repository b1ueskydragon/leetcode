package leetcode.p1920.s2025;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class BuildArrayTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void testBuildArray(int[] nums, int[] converted) {
        assertThat(underTest.buildArray(nums)).isEqualTo(converted);
    }

    static Stream<Arguments> testBuildArray() {
        return Stream.of(
                Arguments.of(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3})
        );
    }
}
