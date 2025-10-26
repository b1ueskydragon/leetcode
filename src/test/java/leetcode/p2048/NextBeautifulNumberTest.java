package leetcode.p2048;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NextBeautifulNumberTest {

    private Solution.V2 v2;
    private Solution.V1 v1;

    @BeforeEach
    void setUp() {
        v2 = new Solution.V2();
        v1 = new Solution.V1();

    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int n, int expected) {
        assertThat(v2.nextBeautifulNumber(n)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int n, int expected) {
        assertThat(v1.nextBeautifulNumber(n)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 22),
                Arguments.of(1000, 1333),
                Arguments.of(1000000, 1224444),
                Arguments.of(122333, 123233),
                Arguments.of(555551, 666666)
        );
    }

}
