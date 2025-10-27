package leetcode.p2125;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfBeamsTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testNumberOfBeams(String[] bank, int expected) {
        assertThat(underTest.numberOfBeams(bank)).isEqualTo(expected);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(new String[]{"011001", "000000", "010100", "001000"}, 8),
                Arguments.of(new String[]{"000", "111", "000"}, 0),
                Arguments.of(new String[]{"000000", "011001", "000000", "010100", "001000", "000000", "000000", "111111"}, 14),
                Arguments.of(new String[]{"111111", "111111", "111111", "111111", "111111", "111111"}, 180),
                Arguments.of(new String[]{"111111", "111111", "111101", "101111", "011111", "111110"}, 141)
        );
    }
}
