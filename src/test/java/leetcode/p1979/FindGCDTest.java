package leetcode.p1979;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindGCDTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testFindGCD(int[] nums, int gcd) {
        assertThat(underTest.findGCD(nums)).isEqualTo(gcd);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{33, 121}, 11),
                Arguments.of(new int[]{34, 121}, 1),
                Arguments.of(new int[]{2, 10}, 2),
                Arguments.of(new int[]{3, 3}, 3)
        );
    }

}
