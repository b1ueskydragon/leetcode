package leetcode.p2048;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NextBeautifulNumberTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNextBeautifulNumber(int n, int expected) {
        assertThat(underTest.nextBeautifulNumber(n)).isEqualTo(expected);
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
