package leetcode.p0717;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TestIsOneBitCharacter {

    private Solution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testIsOneBitCharacter(int[] bits, boolean expected) {
        assertThat(underTest.isOneBitCharacter(bits)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0}, true),
                Arguments.of(new int[]{0, 1, 0, 0}, true),
                Arguments.of(new int[]{0, 1, 1, 0}, true),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0}, true),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0}, true),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 0}, false),
                Arguments.of(new int[]{1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0}, false)
        );
    }

}
