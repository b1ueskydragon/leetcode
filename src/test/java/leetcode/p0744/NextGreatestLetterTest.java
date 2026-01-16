package leetcode.p0744;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NextGreatestLetterTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNextGreatestLetter(char[] letters, char target, char expected) {
        assertThat(underTest.nextGreatestLetter(letters, target)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new char[]{'c', 'f', 'j'}, 'c', 'f'),
                Arguments.of(new char[]{'d', 'f', 'j'}, 'c', 'd'),
                Arguments.of(new char[]{'c', 'f', 'j', 'z'}, 'y', 'z'),
                Arguments.of(new char[]{'a', 'a', 'a', 'b'}, 'a', 'b')
        );
    }
}
