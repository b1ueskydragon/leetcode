package leetcode.p1317;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GetNoZeroIntegersTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testGetNoZeroIntegers(int n, int[] expected) {
        assertThat(underTest.getNoZeroIntegers(n)).containsExactlyInAnyOrder(expected);
    }

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(1011, new int[]{12, 999}),
                Arguments.of(444, new int[]{1, 443}),
                Arguments.of(10000, new int[]{1, 9999}),
                Arguments.of(9999, new int[]{1, 9998}),
                Arguments.of(2, new int[]{1, 1}),
                Arguments.of(501, new int[]{2, 499})
        );
    }

}
