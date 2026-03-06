package leetcode.p1784;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckOnesSegmentTest {

    private Solution.V1 v1;
    private Solution.V2 v2;

    @BeforeEach
    void setUp() {
        v1 = new Solution.V1();
        v2 = new Solution.V2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(String s, boolean expected) {
        assertThat(v1.checkOnesSegment(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(String s, boolean expected) {
        assertThat(v2.checkOnesSegment(s)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("111111110", true),
                Arguments.of("1111111101", false)
        );
    }

}
