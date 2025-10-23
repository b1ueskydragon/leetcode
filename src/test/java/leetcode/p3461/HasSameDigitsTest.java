package leetcode.p3461;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HasSameDigitsTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(String s, boolean expected) {
        assertThat(v2.hasSameDigits(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(String s, boolean expected) {
        assertThat(v1.hasSameDigits(s)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("3902", true),
                Arguments.of("34789", false),
                Arguments.of("44472", false),
                Arguments.of("858", true),
                Arguments.of("323", true),
                Arguments.of("90124125203500921380124125203500921380001818182831001818182831", false)
        );
    }

}
