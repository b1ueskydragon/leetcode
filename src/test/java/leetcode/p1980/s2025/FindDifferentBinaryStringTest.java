package leetcode.p1980.s2025;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindDifferentBinaryStringTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    /**
     * Note: More than one "expected" can exist. But the smallest one may be picked
     */
    @ParameterizedTest
    @MethodSource
    void testFindDifferentBinaryString(String[] given, String expected) {
        assertThat(underTest.findDifferentBinaryString(given)).isEqualTo(expected);
    }

    static Stream<Arguments> testFindDifferentBinaryString() {
        return Stream.of(
                Arguments.of(new String[]{"01", "10"}, "00"),
                Arguments.of(new String[]{"00", "01"}, "10"),
                Arguments.of(new String[]{"111", "011", "001"}, "000"),
                Arguments.of(new String[]{"0"}, "1"),
                Arguments.of(new String[]{"1"}, "0"),
                Arguments.of(new String[]{"1111", "1110", "0000", "1011"}, "0001"),
                Arguments.of(new String[]{
                                     "000000000000", "000000000010", "000000000011", "000000000110",
                                     "000000010011", "000000000101", "000000000111", "000000000001",
                                     "001100011000", "000000001111", "000000000100", "100000000000"},
                             "000000001000")
        );
    }
}
