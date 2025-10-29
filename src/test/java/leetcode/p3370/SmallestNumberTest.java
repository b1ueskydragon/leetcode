package leetcode.p3370;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestNumberTest {

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
        assertThat(v2.smallestNumber(n)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int n, int expected) {
        assertThat(v1.smallestNumber(n)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(3, 3),
                Arguments.of(4, 7),
                Arguments.of(5, 7),
                Arguments.of(512, 1023),
                Arguments.of(999, 1023),
                Arguments.of(1000, 1023)
        );
    }

}
