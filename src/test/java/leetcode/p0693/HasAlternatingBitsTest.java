package leetcode.p0693;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HasAlternatingBitsTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int n, boolean expected) {
        assertThat(v1.hasAlternatingBits(n)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int n, boolean expected) {
        assertThat(v2.hasAlternatingBits(n)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(7, false),
                Arguments.of(11, false),
                Arguments.of(715827882, true),
                Arguments.of(10, true),
                Arguments.of(2147483647, false),
                Arguments.of(1, true)
        );
    }
}
