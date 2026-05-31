package leetcode.p2126;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AsteroidsDestroyedTest {

    private Solution v1;
    private Solution v2;

    @BeforeEach
    void setUp() {
        v1 = new SolutionV1();
        v2 = new SolutionV2();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV1(int mass, int[] asteroids, boolean expected) {
        assertThat(v1.asteroidsDestroyed(mass, asteroids)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testV2(int mass, int[] asteroids, boolean expected) {
        assertThat(v2.asteroidsDestroyed(mass, asteroids)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(10, new int[]{3, 9, 19, 5, 21}, true),
                Arguments.of(5, new int[]{4, 9, 23, 4}, false),
                Arguments.of(1, new int[]{1}, true),
                Arguments.of(1, new int[]{2}, false),
                Arguments.of(5, new int[]{5}, true),
                Arguments.of(10, new int[]{1, 2, 3, 4}, true),
                Arguments.of(2, new int[]{1, 1, 4}, true),
                Arguments.of(2, new int[]{1, 1, 5}, false),
                Arguments.of(10, new int[]{21, 5, 19, 9, 3}, true),
                Arguments.of(50000, new int[]{50000, 50000, 50000}, true),
                Arguments.of(1323, new int[]{1324, 1694, 1954, 3150, 3824, 4332, 5005, 5371}, false),
                Arguments.of(1325, new int[]{1324, 1694, 1954, 3150, 3824, 4332, 5005, 5371}, true)
        );
    }

}
